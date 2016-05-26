package com.mszostok.controller;

import com.mszostok.domain.User;
import com.mszostok.exception.PostException;
import com.mszostok.model.CurrentUser;
import com.mszostok.model.FullPost;
import com.mszostok.model.PostCreateForm;
import com.mszostok.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Post controller to handle post management request mapping.
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/post")
public class PostController {
    private static final Logger LOGGER = LogManager.getLogger(RootController.class);

    private static final String HOME_PAGE_TEMPLATE = "layouts/siteTemplate";
    private static final String HOME_PAGE_CONTENT = "site/postDetails";

    private static final String ADD_POST = "post/addNewPost";

    @Autowired
    PostService postService;

    /**
     * Get logged user domain object.
     *
     * @return User if it logged otherwise return null
     */
    private Optional<User> getLoggedUser(){
        Authentication context = SecurityContextHolder.getContext().getAuthentication();

        User user = null;
        if (context.getPrincipal() instanceof CurrentUser) {
            user = ((CurrentUser) context.getPrincipal()).getUser();
            LOGGER.info("Return logged user : {}", user);
        } else {
            LOGGER.info("Return user is anonymous.");
        }

        return Optional.ofNullable(user);
    }

    @RequestMapping(value = "/{postId}/{postTitle}",method = RequestMethod.GET)
    public ModelAndView postDetailsPage(@PathVariable Optional<Integer> postId,
                              @PathVariable Optional<String> postTitle) throws PostException {

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOME_PAGE_CONTENT);

        FullPost post = postService.getById(postId.orElseThrow(() -> new PostException("Wrong post id.")));
        modelAndView.addObject("post", post);

        LOGGER.info("Return view: {} ",HOME_PAGE_CONTENT);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String savePost(@Valid @ModelAttribute("form") PostCreateForm form, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            LOGGER.error("Post form error {} ", result);
            attr.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            attr.addFlashAttribute("form", form);
            return "redirect:/post/add-form";
        }
        postService.save(form, getLoggedUser());

        LOGGER.info("Redirect to home page with success created post message.");
        attr.addFlashAttribute("message", "<strong>Success!</strong> Post was added.");
        return "redirect:/";
    }

    @RequestMapping(value = "/add-form",method = RequestMethod.GET)
    public String addNewPost(Model model) {

        model.addAttribute("pageContentPath", ADD_POST);
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new PostCreateForm());
        }
        LOGGER.info("Return view: {} ", ADD_POST);
        return HOME_PAGE_TEMPLATE;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePost(@PathVariable int id, HttpServletRequest request) {
        LOGGER.info("Execute deletePost method - only for ADMIN user");

        postService.deactivateById(id);

        String referer = request.getHeader("Referer");
        LOGGER.info("Redirect view to: {} ", referer);
        return "redirect:" + referer;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/restore/{id}", method = RequestMethod.POST)
    public String restorePost(@PathVariable int id, HttpServletRequest request) {
        LOGGER.info("Execute restorePost method - only for ADMIN user");

        postService.restoreById(id);

        String referer = request.getHeader("Referer");
        LOGGER.info("Redirect view to: {} ", referer);
        return "redirect:" + referer;
    }
}

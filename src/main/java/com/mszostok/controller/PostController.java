package com.mszostok.controller;

import com.mszostok.exception.PostException;
import com.mszostok.model.FullPost;
import com.mszostok.model.PostCreateForm;
import com.mszostok.service.PostService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Post controller
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

    @RequestMapping(method = RequestMethod.POST)
    public String savePost(@Valid @ModelAttribute("form") PostCreateForm form, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            attr.addFlashAttribute("form", form);
            return "redirect:/post/add-form";
        }
        postService.save(form);
        attr.addFlashAttribute("message", "<strong>Success!</strong> Post was added.");
        return "redirect:/";
    }

    @RequestMapping(value = "/{postId}/{postTitle}",method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Optional<Integer> postId,
                              @PathVariable Optional<String> postTitle) throws PostException {

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOME_PAGE_CONTENT);

        FullPost post = postService.getById(postId.orElseThrow(() -> new PostException("Wrong post id.")));
        modelAndView.addObject("post", post);

        LOGGER.info("Return view: ".concat(HOME_PAGE_CONTENT));
        return modelAndView;
    }

    @RequestMapping(value = "/add-form",method = RequestMethod.GET)
    public String addNewPost(Model model) {

        model.addAttribute("pageContentPath", ADD_POST);
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new PostCreateForm());
        }
        LOGGER.info("Return view: ".concat(ADD_POST));
        return HOME_PAGE_TEMPLATE;
    }
}

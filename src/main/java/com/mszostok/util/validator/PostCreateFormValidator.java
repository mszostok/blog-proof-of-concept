package com.mszostok.util.validator;

import com.mszostok.model.PostCreateForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

@Component
public class PostCreateFormValidator implements Validator {
    private static final Logger LOGGER = LogManager.getLogger(PostCreateFormValidator.class);

    private static final Integer MAX_TAG_LENGTH = 50;

    private void validateTagsLength(Errors errors, PostCreateForm form) {
        LOGGER.info("Validate tags length string from input");
        //remove all html tags
        String safeTagsInput = Jsoup.parse(form.getTagsInput()).text();

        //remove all whitespace, create list with comma delimiter
        List<String> tagsList = Arrays.asList(safeTagsInput.split(","));

        boolean toLongTag = tagsList.stream().anyMatch(s -> s.trim().length() > MAX_TAG_LENGTH);

        if (toLongTag) {
            LOGGER.warn("Detected wrong tag length");
            errors.rejectValue("tagsInput", "tagsInput.wrong_length", "The maximum tag length is 50 characters.");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PostCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostCreateForm form = (PostCreateForm) target;
        validateTagsLength(errors, form);
    }




}

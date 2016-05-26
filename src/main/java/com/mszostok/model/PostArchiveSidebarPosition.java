package com.mszostok.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Sidebar archive position model which create proper url to get post archive page for given date.
 *
 * @author mszostok
 */
public class PostArchiveSidebarPosition {

    private final String URL_PREFIX = "/post/archive/{YEAR_MONTH}";

    private final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
    private final DateTimeFormatter URL_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM", Locale.ENGLISH);

    private String archivePageUrl;
    private String displayName;

    public PostArchiveSidebarPosition() {
    }

    public PostArchiveSidebarPosition(YearMonth date) {
        archivePageUrl = URL_PREFIX.replace("{YEAR_MONTH}", date.format(URL_FORMATTER));
        displayName = date.format(DISPLAY_FORMATTER);
    }

    public String getArchivePageUrl() {
        return archivePageUrl;
    }

    public void setArchivePageUrl(String archivePageUrl) {
        this.archivePageUrl = archivePageUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

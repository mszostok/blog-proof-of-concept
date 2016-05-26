package com.mszostok.service;

import com.mszostok.model.PostArchiveSidebarPosition;

import java.util.*;

/**
 * @author mszostok
 */
public interface PostArchiveSidebarService {

     List<PostArchiveSidebarPosition> getArchiveList();

     Boolean getUpdate();

     void setUpdate(Boolean update);
}

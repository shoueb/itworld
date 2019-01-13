package com.shoueb.itworld.author.model;

import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
 /**
  * @Description: 任务情况
  * @Author: zzq
  * @Date: 2019/1/12
*/
 @Table(name = "t_task_main")
public class TaskMain extends BaseEntity implements Serializable {
     /**
      *任务名称
      */
     private String taskName;
     /**
      *作者ID
      */
     private Long authorId;
     /**
      *作者用户名
      */
     private String authorUserName;
     /**
      *作者真实姓名
      */
     private String authorRealName;
     /**
      *作者武侠名
      */
     private String authorKhName;
     /**
      *项目ID
      */
     private Long projectId;
     /**
      *项目名称
      */
     private String projectName;
     /**
      *看板ID
      */
     private Long boardId;
     /**
      *看板名称
      */
     private String boardName;
     /**
      *描述
      */
     private String taskMem;
     /**
      *默认附件地址
      */
     private String attachmentDefualtUrl;
     /**
      *任务开始
      */
     private Date taskStart;
     /**
      *任务结束
      */
     private Date taskEnd;
     /**
      *上级任务 0为最顶任务
      */
     private Long parentId;
     /**
      *优先级
      */
     private Integer priority;
     /**
      *任务状态
      */
     private String status;
     /**
      *是否开启提醒 1提醒 0不提醒
      */
     private String isWarning;
     /**
      *告警几次
      */
     private Integer warningCount;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorUserName() {
        return authorUserName;
    }

    public void setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
    }

    public String getAuthorRealName() {
        return authorRealName;
    }

    public void setAuthorRealName(String authorRealName) {
        this.authorRealName = authorRealName;
    }

    public String getAuthorKhName() {
        return authorKhName;
    }

    public void setAuthorKhName(String authorKhName) {
        this.authorKhName = authorKhName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getTaskMem() {
        return taskMem;
    }

    public void setTaskMem(String taskMem) {
        this.taskMem = taskMem;
    }

    public String getAttachmentDefualtUrl() {
        return attachmentDefualtUrl;
    }

    public void setAttachmentDefualtUrl(String attachmentDefualtUrl) {
        this.attachmentDefualtUrl = attachmentDefualtUrl;
    }

    public Date getTaskStart() {
        return taskStart;
    }

    public void setTaskStart(Date taskStart) {
        this.taskStart = taskStart;
    }

    public Date getTaskEnd() {
        return taskEnd;
    }

    public void setTaskEnd(Date taskEnd) {
        this.taskEnd = taskEnd;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(String isWarning) {
        this.isWarning = isWarning;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }


}

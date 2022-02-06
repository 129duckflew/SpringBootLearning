package cn.duckflew;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;



public class MkTableTest
{
//    @Test
//    public void mkTable()
//    {
//        /**
//         * 使用activiti默认方式创建表
//         */
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//    }
//
//    @Test
//    public void ZiDingYiProcessEngine()
//    {
//        /**
//         * 使用activiti默认方式创建表
//         */
//        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//        ProcessEngine processEngine = configuration.buildProcessEngine();
//    }
    @Test
    public void deployProcess()
    {
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        InputStream zipResourcesInputStream = classLoader.getResourceAsStream("bpmn/qingjia.zip");
//        assert zipResourcesInputStream != null;
//        ZipInputStream zipInputStream = new ZipInputStream(zipResourcesInputStream);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
//        使用repositoryService进行部署操作
        Deployment qingjia = repositoryService.createDeployment().addClasspathResource("bpmn/qingjia.bpmn").addClasspathResource("bpmn/qingjia.png").name("qingjia").key("qingjia").deploy();
//        Deployment qingjia = repositoryService.createDeployment().addZipInputStream(zipInputStream).key("qingjia").name("请假").deploy();
        System.out.println(qingjia.getId());
        System.out.println(qingjia.getKey());
        System.out.println(qingjia.getName());
        System.out.println(qingjia.getDeploymentTime());
    }
    @Test
    public void runProcessInstance()
    {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService=processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");
        System.out.println("流程定义的id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例的id:"+processInstance.getId());
        System.out.println("当前活动的Id:"+processInstance.getActivityId());
    }
    @Test
    public void  handleProcessTask()
    {
        /**
         * 流程启动后 任务的负责人可以查询自己当前能够处理的任务了
         * 查询出来的任务都是
         */
        String assignee ="lisi";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> qingjia = taskService.createTaskQuery().processDefinitionKey("qingjia").taskAssignee(assignee).list();
        for (Task task : qingjia)
        {
            System.out.println("流程实例Id"+task.getProcessInstanceId());
            System.out.println("taskId"+task.getId());
            System.out.println("任务负责人"+task.getAssignee());
            System.out.println("任务名称"+task.getName());
        }
    }
    @Test
    public void test05()
    {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().processDefinitionKey("qingjia").taskAssignee("zhangsan").singleResult();
        taskService.complete(task.getId());
    }


}

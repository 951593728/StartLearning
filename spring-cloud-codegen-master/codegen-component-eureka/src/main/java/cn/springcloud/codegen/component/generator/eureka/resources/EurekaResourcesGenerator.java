package cn.springcloud.codegen.component.generator.eureka.resources;

import cn.springcloud.codegen.engine.constant.SkeletonConstant;
import cn.springcloud.codegen.engine.context.SkeletonContext;
import cn.springcloud.codegen.engine.generator.SkeletonFileGenerator;
import cn.springcloud.codegen.engine.property.SkeletonProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/22
 * @time: 23:59
 * @description : do some thing
 */
public class EurekaResourcesGenerator extends SkeletonFileGenerator{

    public EurekaResourcesGenerator(SkeletonContext skeletonContext, SkeletonProperties skeletonProperties) {
        super(skeletonContext.clone("eureka", EurekaResourcesGenerator.class), skeletonProperties);
    }

    @Override
    protected String getFileName() {
        return "application.properties";
    }

    @Override
    protected String getTemplateName() {
        return "application.properties.template";
    }

    @Override
    protected String getOutputPath() {
        return super.getOutputPath() + SkeletonConstant.MAIN_RESOURCES_FILE_PATH;
    }

    @Override
    protected Object getDataModel() {
        Map<String, Object> dataModel = new HashMap<String, Object>();
        dataModel.put("serviceName", skeletonProperties.getString("productName") + "-" + getSkeletonContext().getProjectType());


        /*dataModel.put("port", skeletonProperties.getString("eurekaPort"));
        dataModel.put("eurekaUrl", skeletonProperties.getString("registryUrl"));*/

        return dataModel;
    }
}

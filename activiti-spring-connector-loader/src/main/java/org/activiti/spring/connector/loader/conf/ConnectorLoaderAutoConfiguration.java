/*
 * Copyright 2019 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.spring.connector.loader.conf;

import org.activiti.core.common.spring.connector.ConnectorReader;
import org.activiti.engine.RepositoryService;
import org.activiti.spring.connector.loader.ProcessConnectorService;
import org.activiti.spring.resources.DeploymentResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectorLoaderAutoConfiguration {

    @Bean
    public ProcessConnectorService processConnectorService(RepositoryService repositoryService,
                                                           ConnectorReader connectorReader) {
        return new ProcessConnectorService(new DeploymentResourceLoader<>(repositoryService),
                                           connectorReader,
                                           repositoryService);
    }
}
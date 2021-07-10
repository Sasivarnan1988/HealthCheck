package com.user.info.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("UserInfoAPI")
public class UserInfoSystemHC implements CompositeHealthContributor {

        private Map<String, HealthContributor>
                contributors = new LinkedHashMap<>();

        @Autowired
        public UserInfoSystemHC(
                ExternalAPIHC
                        externalApiHealthContributor,
                DatabaseHC
                        databaseHealthContributor) {
            super();
            contributors.put("externalApi",
                    externalApiHealthContributor);
            contributors.put("database",
                    databaseHealthContributor);
        }

        @Override
        public Iterator<NamedContributor<HealthContributor>>
        iterator() {
            return contributors.entrySet().stream()
                    .map((entry) ->
                            NamedContributor.of(entry.getKey(),
                                    entry.getValue())).iterator();
        }

        @Override
        public HealthContributor getContributor(String name) {
            return contributors.get(name);
        }


    }


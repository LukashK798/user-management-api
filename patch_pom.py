with open('pom.xml', 'r') as f:
    content = f.read()

import re
new_content = re.sub(r'\s*<!-- Swagger UI -->\s*<dependency>\s*<groupId>org.springdoc</groupId>\s*<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>\s*<version>[^<]*</version>\s*</dependency>', '', content)

with open('pom.xml', 'w') as f:
    f.write(new_content)

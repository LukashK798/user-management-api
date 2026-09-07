import xml.etree.ElementTree as ET

with open('pom.xml', 'r') as f:
    content = f.read()

# Add mapstruct dependency
dep_str = """
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>1.5.5.Final</version>
        </dependency>
"""
content = content.replace('</dependencies>', dep_str + '    </dependencies>')

# Add mapstruct and lombok-mapstruct-binding to annotationProcessorPaths
old_paths = """<path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </path>"""

new_paths = """<path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </path>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>1.5.5.Final</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>0.2.0</version>
                        </path>"""
content = content.replace(old_paths, new_paths)

with open('pom.xml', 'w') as f:
    f.write(content)

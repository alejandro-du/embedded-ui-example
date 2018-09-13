[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/embedded-ui)
[![Stars on vaadin.com/directory](https://img.shields.io/vaadin-directory/star/embedded-ui.svg)](https://vaadin.com/directory/component/embedded-ui)

# Embedded UI add-on example

[Embedded](https://vaadin.com/directory#!addon/embedded-ui) UI is a Vaadin add-on that allows inserting multiple Vaadin applications hosted in different servers into Vaadin layouts:
```
VaadinUIComponent ui1 = new VaadinUIComponent("http://test.com");
VaadinUIComponent ui2 = new VaadinUIComponent("http://test2.com/vaadin-app");

someLayout.addComponents(ui1, ui2);
```
This example shows how to configure one host and 2 external Vaadin applications.

## Running the example

Download and compile the example:
```
git clone https://github.com/alejandro-du/embedded-ui-example.git
cd embedded-ui-example
mvn package
```
Run the 3 applications in 3 separate terminals:
```
cd embedded1
mvn jetty:run
```

```
cd embedded2
mvn jetty:run
```

```
cd host
mvn jetty:run
```

Point your browser to <http://localhost:8080> and see how the two embedded applications are rendered in the host Vaadin application.

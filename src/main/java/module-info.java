module ogame.web{
        requires selenium.api;
        requires selenium.chrome.driver;

        opens ogame.web to javax.xml.bind, TestV2;

        exports ogame.web.actions;
        exports ogame.web.buildings;
        exports ogame.web.defence;
        exports ogame.web.eventbox;
        exports ogame.web.galaxy;
        exports ogame.web.planets;
        exports ogame.web.researches;
        exports ogame.web.ships;
        exports ogame.web.tabs;
        exports ogame.web.utils;
        exports ogame.web.utils.log;
        exports ogame.web.utils.watch;
        exports ogame.web.watch;
        exports ogame.web;
}

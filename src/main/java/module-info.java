module ogame{
        requires selenium.api;
        requires selenium.chrome.driver;

        opens ogame to javax.xml.bind, TestV2;

        exports ogame.actions;
        exports ogame.buildings;
        exports ogame.defence;
        exports ogame.eventbox;
        exports ogame.galaxy;
        exports ogame.planets;
        exports ogame.researches;
        exports ogame.ships;
        exports ogame.tabs;
        exports ogame.utils;
        exports ogame.utils.log;
        exports ogame.utils.watch;
        exports ogame.watch;
        exports ogame;
}

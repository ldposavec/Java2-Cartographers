package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.CardsBase;
import hr.algebra.java2.cartographers.model.ShapeOnMap;
import hr.algebra.java2.cartographers.model.TerrainType;

import java.util.ArrayList;
import java.util.Collections;

public class InitializeUtils {
    private InitializeUtils() {
    }
    public static ArrayList<CardsBase> initializeExploreDeck() {
        ArrayList<CardsBase> exploreDeck = new ArrayList<>();
        CardsBase treetopVillage = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Treetop Village")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.VILLAGE})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("E");
                    add("E");
                    add("N");
                    add("E");
                }}, false),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                        }}, false)})
                .build();
        CardsBase outpostRuins = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Outpost Ruins")
                .setTerrainType(new TerrainType[]{TerrainType.RUINS})
                .setNumberOfShapes(1)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase farmland = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Farmland")
                .setTerrainType(new TerrainType[]{TerrainType.FARM})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("N");
                            add("O");
                            add("E");
                            add("S");
                            add("O");
                            add("S");
                            add("W");
                            add("O");
                            add("W");
                            add("N");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase forgottenForest = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Forgotten Forest")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("O");
                    add("E");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("S");
                            add("E");
                            add("S");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase orchard = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Orchard")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.FARM})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {
                    {
                        add("X");
                        add("E");
                        add("E");
                        add("S");
                    }
                }, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase hamlet = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Hamlet")
                .setTerrainType(new TerrainType[]{TerrainType.VILLAGE})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("W");
                            add("W");
                            add("S");
                            add("E");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase riftLands = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Rift Lands")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.VILLAGE, TerrainType.FARM,
                        TerrainType.WATER, TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase homestead = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Homestead")
                .setTerrainType(new TerrainType[]{TerrainType.FARM, TerrainType.VILLAGE})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                    add("O");
                    add("S");
                    add("W");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase hinterlandStream = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Hinterland Stream")
                .setTerrainType(new TerrainType[]{TerrainType.FARM, TerrainType.WATER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("N");
                    add("N");
                    add("E");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase greatRiver = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Great River")
                .setTerrainType(new TerrainType[]{TerrainType.WATER})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("E");
                            add("N");
                            add("E");
                            add("N");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase templeRuins = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Temple Ruins")
                .setTerrainType(new TerrainType[]{TerrainType.RUINS})
                .setNumberOfShapes(1)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase marshlands = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Marshlands")
                .setTerrainType(new TerrainType[]{TerrainType.WATER, TerrainType.FOREST})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("S");
                    add("O");
                    add("E");
                    add("N");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase fishingVillage = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Fishing Village")
                .setTerrainType(new TerrainType[]{TerrainType.VILLAGE, TerrainType.WATER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("E");
                    add("E");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase koboldOnslaught = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Kobold Onslaught")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                    add("O");
                    add("S");
                    add("W");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase bugbearAssault = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Bugbear Assault")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("O");
                    add("E");
                    add("E");
                    add("N");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase goblinAttack = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Goblin Attack")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("O");
                    add("E");
                    add("S");
                    add("O");
                    add("E");
                    add("S");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase gnollRaid = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Gnoll Raid")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("W");
                    add("S");
                    add("S");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();

        exploreDeck.add(treetopVillage);
        exploreDeck.add(outpostRuins);
        exploreDeck.add(farmland);
        exploreDeck.add(forgottenForest);
        exploreDeck.add(orchard);
        exploreDeck.add(hamlet);
        exploreDeck.add(riftLands);
        exploreDeck.add(homestead);
        exploreDeck.add(hinterlandStream);
        exploreDeck.add(greatRiver);
        exploreDeck.add(templeRuins);
        exploreDeck.add(marshlands);
        exploreDeck.add(fishingVillage);
        exploreDeck.add(koboldOnslaught);
        exploreDeck.add(bugbearAssault);
        exploreDeck.add(goblinAttack);
        exploreDeck.add(gnollRaid);

        Collections.shuffle(exploreDeck);

        return exploreDeck;
    }
}

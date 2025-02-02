package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.GameMove;
import hr.algebra.java2.cartographers.model.GameMoveTag;
import hr.algebra.java2.cartographers.model.Position;
import hr.algebra.java2.cartographers.model.SeasonEnum;
import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlUtils {
    private XmlUtils() {}

    public static final String DOCTYPE = "DOCTYPE";
    public static final String DTD = "dtd/gameMoves.dtd";
    public static final String GAME_MOVES = "GameMoves";
    public static final String FILENAME = "xml/gameMoves.xml";

    public static void saveNewMove(GameMove move) {
        List<GameMove> gameMoveList = null;
        try {
            gameMoveList = loadGameMoves();
            Document document = createDocument(GAME_MOVES);


            if (gameMoveList.isEmpty()) {
                appendGameMove(move, document);
            } else {
                gameMoveList.add(move);
                for (GameMove nextGameMove : gameMoveList) {
                    appendGameMove(nextGameMove, document);
                }
            }

            File saveFile = new File(FILENAME);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }

            saveDocument(document, FILENAME);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveDocument(Document document, String filename) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, document.getDoctype().getSystemId());
        transformer.transform(new DOMSource(document), new StreamResult(new File(filename)));
    }

    private static Document createDocument(String element) throws ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        DOMImplementation domImpl = builder.getDOMImplementation();
        DocumentType docType = domImpl.createDocumentType(DOCTYPE, null, DTD);
        return domImpl.createDocument(null, element, docType);
    }

    private static List<GameMove> loadGameMoves() {
        return parse(FILENAME);
    }

    private static List<GameMove> parse(String path) {
        if(!Files.exists(Path.of(path))) {
            return new ArrayList<>();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getStackTrace());
        }
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println(exception.getStackTrace());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println(exception.getStackTrace());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println(exception.getStackTrace());
            }
        });
        Document document = null;
        try {
            document = builder.parse(new File(path));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return retrieveGameMoves(document);
    }

    private static List<GameMove> retrieveGameMoves(Document document) {
        List<GameMove> gameMoves = new ArrayList<>();
        Element documentElement = document.getDocumentElement();
        NodeList nodes = documentElement.getElementsByTagName(GameMoveTag.GAME_MOVE.getTagName());
        for (int i = 0; i < nodes.getLength(); i++) {
            GameMove gameMove = new GameMove();
            Element item = (Element) nodes.item(i);
            gameMove.setTurnCount(
                    Integer.parseInt(item.getElementsByTagName(
                            GameMoveTag.TURN_COUNT.getTagName()).item(0).getTextContent()));
            gameMove.setSeason(SeasonEnum.valueOf(
                    item.getElementsByTagName(GameMoveTag.SEASON.getTagName()).item(0).getTextContent()));
            Position gameMovePosition = new Position();
            gameMovePosition.setColumn(Integer.parseInt(
                    item.getElementsByTagName(
                            GameMoveTag.POSITION_X.getTagName()).item(0).getTextContent()
                    )
            );
            gameMovePosition.setRow(Integer.parseInt(
                    item.getElementsByTagName(
                            GameMoveTag.POSITION_Y.getTagName()).item(0).getTextContent()
                    )
            );
            gameMove.setPosition(gameMovePosition);
            gameMove.setCoinCount(
                    Integer.parseInt(item.getElementsByTagName(
                            GameMoveTag.COIN_COUNT.getTagName()).item(0).getTextContent()));
//            gameMove.setPoints(new String[][]{
//                    item.getElementsByTagName(GameMoveTag.POINTS.getTagName()).item(0).getTextContent().split(",")});
            gameMoves.add(gameMove);
        }

        return gameMoves;
    }

    private static void appendGameMove(GameMove move, Document document) {
        Element gameMove = document.createElement(GameMoveTag.GAME_MOVE.getTagName());
        Element turnCount = document.createElement(GameMoveTag.TURN_COUNT.getTagName());
        turnCount.setTextContent(String.valueOf(move.getTurnCount()));
        gameMove.appendChild(turnCount);

        Element season = document.createElement(GameMoveTag.SEASON.getTagName());
        season.setTextContent(move.getSeason().name());
        gameMove.appendChild(season);

        Element positionX = document.createElement(GameMoveTag.POSITION_X.getTagName());
        positionX.setTextContent(String.valueOf(move.getPosition().getColumn()));
        gameMove.appendChild(positionX);

        Element positionY = document.createElement(GameMoveTag.POSITION_Y.getTagName());
        positionY.setTextContent(String.valueOf(move.getPosition().getRow()));
        gameMove.appendChild(positionY);

        Element coinCount = document.createElement(GameMoveTag.COIN_COUNT.getTagName());
        coinCount.setTextContent(String.valueOf(move.getCoinCount()));
        gameMove.appendChild(coinCount);

//        Element points = document.createElement(GameMoveTag.POINTS.getTagName());
//        points.setTextContent(String.join(",", move.getPoints()[0]));
//        gameMove.appendChild(points);

        document.getDocumentElement().appendChild(gameMove);
    }
}

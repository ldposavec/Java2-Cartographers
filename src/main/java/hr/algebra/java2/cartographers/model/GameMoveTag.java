package hr.algebra.java2.cartographers.model;

public enum GameMoveTag {
    GAME_MOVE("GameMove"),
    TURN_COUNT("TurnCount"),
    SEASON("Season"),
    POSITION_X("PositionX"),
    POSITION_Y("PositionY"),
    COIN_COUNT("CoinCount");
//    POINTS("Points");

    private String tagName;

    GameMoveTag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}

//package net.runelite.cache.definitions;
//
//import net.runelite.cache.io.InputStream;
//import net.runelite.cache.utils.StringUtilities;
//
///**
// * Created by Allen Kinzalow on 3/14/2015.
// */
//public class ItemDefinition extends Definition {
//
//    public final static int INDEX_ID = 2;
//    public final static int ARCHIVE_ID = 10;
//
//    public int resizeY;
//    public int xan2d = 0;
//    public int cost = 1;
//    public int inventoryModel;
//    public int resizeZ;
//    public short[] colorFind;
//    public short[] colorReplace;
//    public short[] textureFind;
//    public String name = "null";
//    public int zoom2d = 200000;
//    public int yan2d = 0;
//    public int zan2d = 0;
//    public int maleOffset;
//    public int yOffset2d = 0;
//    public int stackable = 0;
//    public int[] countCo;
//    public boolean members = false;
//    public String[] options;
//    public String[] interfaceOptions;
//    public int maleModel0;
//    public int maleModel1;
//    public short[] textureReplace;
//    public int femaleModel1;
//    public int femaleOffset;
//    public int maleModel2;
//    public int xOffset2d = 0;
//    public int maleHeadModel;
//    public int maleHeadModel2;
//    public int femaleHeadModel;
//    public int femaleHeadModel2;
//    public int[] countObj;
//    public int femaleModel2;
//    public int notedID;
//    public int femaleModel0;
//    public int resizeX;
//    public int notedTemplate;
//    public int ambient;
//    public int contrast;
//    public int team;
//
//    public ItemDefinition(int definitionID) {
//        super(definitionID);
//        this.options = new String[]{null, null, "Take", null, null};
//        this.interfaceOptions = new String[]{null, null, null, null, "Drop"};
//        this.maleModel0 = -1;
//        this.maleModel1 = -1;
//        this.maleOffset = 0;
//        this.femaleModel0 = -1;
//        this.femaleModel1 = -1;
//        this.femaleOffset = 0;
//        this.maleModel2 = -1;
//        this.femaleModel2 = -1;
//        this.maleHeadModel = -1;
//        this.maleHeadModel2 = -1;
//        this.femaleHeadModel = -1;
//        this.femaleHeadModel2 = -1;
//        this.notedID = -1;
//        this.notedTemplate = -1;
//        this.resizeX = 0;
//        this.resizeY = 0;
//        this.resizeZ = 0;
//        this.ambient = 0;
//        this.contrast = 0;
//        this.team = 0;
//    }
//
//    @Override
//    void decodeValues(int opcode, InputStream stream) {
//        if (opcode == 1) {
//            this.inventoryModel = stream.readUnsignedShort();
//        } else if (opcode == 2) {
//            this.name = StringUtilities.readString_2(stream);
//        } else if (opcode == 4) {
//            this.zoom2d = stream.readUnsignedShort();
//        } else if (opcode == 5) {
//            this.xan2d = stream.readUnsignedShort();
//        } else if (opcode == 6) {
//            this.yan2d = stream.readUnsignedShort();
//        } else if (7 == opcode) {
//            this.xOffset2d = stream.readUnsignedShort();
//            if (this.xOffset2d > 32767) {
//                this.xOffset2d -= 65536;
//            }
//        } else if (8 == opcode) {
//            this.yOffset2d = stream.readUnsignedShort();
//            if (this.yOffset2d > 32767) {
//                this.yOffset2d -= 65536;
//            }
//        } else if (11 == opcode) {
//            this.stackable = 1;
//        } else if (opcode == 12) {
//            this.cost = stream.readInt();
//        } else if (16 == opcode) {
//            this.members = true;
//        } else if (opcode == 23) {
//            this.maleModel0 = stream.readUnsignedShort();
//            this.maleOffset = stream.readUnsignedByte();
//        } else if (opcode == 24) {
//            this.maleModel1 = stream.readUnsignedShort();
//        } else if (25 == opcode) {
//            this.femaleModel0 = stream.readUnsignedShort();
//            this.femaleOffset = stream.readUnsignedByte();
//        } else if (26 == opcode) {
//            this.femaleModel1 = stream.readUnsignedShort();
//        } else if (opcode >= 30 && opcode < 35) {
//            this.options[opcode - 30] = StringUtilities.readString_2(stream);
//            if (this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
//                this.options[opcode - 30] = null;
//            }
//        } else if (opcode >= 35 && opcode < 40) {
//            this.interfaceOptions[opcode - 35] = StringUtilities.readString_2(stream);
//        } else {
//            int var4;
//            int var5;
//            if (opcode == 40) {
//                var5 = stream.readUnsignedByte();
//                this.colorFind = new short[var5];
//                this.colorReplace = new short[var5];
//
//                for (var4 = 0; var4 < var5; ++var4) {
//                    this.colorFind[var4] = (short) stream.readUnsignedShort();
//                    this.colorReplace[var4] = (short) stream.readUnsignedShort();
//                }
//
//            } else if (41 != opcode) {
//                if (opcode == 78) {
//                    this.maleModel2 = stream.readUnsignedShort();
//                } else if (opcode == 79) {
//                    this.femaleModel2 = stream.readUnsignedShort();
//                } else if (90 == opcode) {
//                    this.maleHeadModel = stream.readUnsignedShort();
//                } else if (91 == opcode) {
//                    this.femaleHeadModel = stream.readUnsignedShort();
//                } else if (92 == opcode) {
//                    this.maleHeadModel2 = stream.readUnsignedShort();
//                } else if (opcode == 93) {
//                    this.femaleHeadModel2 = stream.readUnsignedShort();
//                } else if (opcode == 95) {
//                    this.zan2d = stream.readUnsignedShort();
//                } else if (97 == opcode) {
//                    this.notedID = stream.readUnsignedShort();
//                } else if (98 == opcode) {
//                    this.notedTemplate = stream.readUnsignedShort();
//                } else if (opcode >= 100 && opcode < 110) {
//                    if (this.countObj == null) {
//                        this.countObj = new int[10];
//                        this.countCo = new int[10];
//                    }
//
//                    this.countObj[opcode - 100] = stream.readUnsignedShort();
//                    this.countCo[opcode - 100] = stream.readUnsignedShort();
//                } else if (110 == opcode) {
//                    this.resizeX = stream.readUnsignedShort();
//                } else if (opcode == 111) {
//                    this.resizeY = stream.readUnsignedShort();
//                } else if (opcode == 112) {
//                    this.resizeZ = stream.readUnsignedShort();
//                } else if (opcode == 113) {
//                    this.ambient = stream.readByte();
//                } else if (114 == opcode) {
//                    this.contrast = stream.readByte();
//                } else if (115 == opcode) {
//                    this.team = stream.readUnsignedByte();
//                }
//            } else {
//                var5 = stream.readUnsignedByte();
//                this.textureFind = new short[var5];
//                this.textureReplace = new short[var5];
//
//                for (var4 = 0; var4 < var5; ++var4) {
//                    this.textureFind[var4] = (short) stream.readUnsignedShort();
//                    this.textureReplace[var4] = (short) stream.readUnsignedShort();
//                }
//
//            }
//        }
//    }
//}

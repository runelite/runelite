//package net.runelite.cache.definitions;
//
//import net.runelite.cache.io.InputStream;
//import net.runelite.cache.utils.StringUtilities;
//
///**
// * Created by Allen Kinzalow on 3/15/2015.
// */
//public class NPCDefinition extends Definition {
//
//    public final static int INDEX_ID = 2;
//    public final static int ARCHIVE_ID = 9;
//
//    public short[] recolorToFind;
//    public int anInt2156 = 32;
//    public String name = "null";
//    public short[] recolorToReplace;
//    public int[] models;
//    public int[] models_2;
//    public int stanceAnimation = -1;
//    public int anInt2165 = -1;
//    public int tileSpacesOccupied = 1;
//    public int walkAnimation = -1;
//    public short[] retextureToReplace;
//    public int rotate90RightAnimation = -1;
//    public boolean aBool2170 = true;
//    public int resizeX = 128;
//    public int contrast = 0;
//    public int rotate180Animation = -1;
//    public int anInt2174 = -1;
//    public String[] options = new String[5];
//    public boolean renderOnMinimap = true;
//    public int combatLevel = -1;
//    public int rotate90LeftAnimation = -1;
//    public int resizeY = 128;
//    public boolean hasRenderPriority = false;
//    public int ambient = 0;
//    public int headIcon = -1;
//    public int anInt2184 = 30;
//    public int[] anIntArray2185;
//    public short[] retextureToFind;
//    public int anInt2187 = -1;
//    public boolean isClickable = true;
//    public int anInt2189 = -1;
//    public boolean aBool2190 = false;
//
//    public NPCDefinition(int definitionID) {
//        super(definitionID);
//    }
//
//    @Override
//    void decodeValues(int opcode, InputStream stream) {
//        int length;
//        int index;
//        if(1 == opcode) {
//            length = stream.readUnsignedByte();
//            this.models = new int[length];
//
//            for(index = 0; index < length; ++index) {
//                this.models[index] = stream.readUnsignedShort();
//            }
//
//        } else if(2 == opcode) {
//            this.name = StringUtilities.readString_2(stream);
//        } else if(12 == opcode) {
//            this.tileSpacesOccupied = stream.readUnsignedShort();
//        } else if(opcode == 13) {
//            this.stanceAnimation = stream.readUnsignedShort();
//        } else if(opcode == 14) {
//            this.walkAnimation = stream.readUnsignedShort();
//        } else if(15 == opcode) {
//            this.anInt2165 = stream.readUnsignedShort();
//        } else if(opcode == 16) {
//            this.anInt2189 = stream.readUnsignedShort();
//        } else if(17 == opcode) {
//            this.walkAnimation = stream.readUnsignedShort();
//            this.rotate180Animation = stream.readUnsignedShort();
//            this.rotate90RightAnimation = stream.readUnsignedShort();
//            this.rotate90LeftAnimation = stream.readUnsignedShort();
//        } else if(opcode >= 30 && opcode < 35) {
//            this.options[opcode - 30] = StringUtilities.readString_2(stream);
//            if(this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
//                this.options[opcode - 30] = null;
//            }
//        } else if(opcode == 40) {
//            length = stream.readUnsignedByte();
//            this.recolorToFind = new short[length];
//            this.recolorToReplace = new short[length];
//
//            for(index = 0; index < length; ++index) {
//                this.recolorToFind[index] = (short)stream.readUnsignedShort();
//                this.recolorToReplace[index] = (short)stream.readUnsignedShort();
//            }
//
//        } else if(opcode == 41) {
//            length = stream.readUnsignedByte();
//            this.retextureToFind = new short[length];
//            this.retextureToReplace = new short[length];
//
//            for(index = 0; index < length; ++index) {
//                this.retextureToFind[index] = (short)stream.readUnsignedShort();
//                this.retextureToReplace[index] = (short)stream.readUnsignedShort();
//            }
//
//        } else if(60 != opcode) {
//            if(opcode == 93) {
//                this.renderOnMinimap = false;
//            } else if(95 == opcode) {
//                this.combatLevel = stream.readUnsignedShort();
//            } else if(97 == opcode) {
//                this.resizeX = stream.readUnsignedShort();
//            } else if(98 == opcode) {
//                this.resizeY = stream.readUnsignedShort();
//            } else if(opcode == 99) {
//                this.hasRenderPriority = true;
//            } else if(100 == opcode) {
//                this.ambient = stream.readByte();
//            } else if(101 == opcode) {
//                this.contrast = stream.readByte();
//            } else if(opcode == 102) {
//                this.headIcon = stream.readUnsignedShort();
//            } else if(103 == opcode) {
//                this.anInt2156 = stream.readUnsignedShort();
//            } else if(opcode == 106) {
//                this.anInt2174 = stream.readUnsignedShort();
//                if('\uffff' == this.anInt2174) {
//                    this.anInt2174 = -1;
//                }
//
//                this.anInt2187 = stream.readUnsignedShort();
//                if('\uffff' == this.anInt2187) {
//                    this.anInt2187 = -40212193;
//                }
//
//                length = stream.readUnsignedByte();
//                this.anIntArray2185 = new int[length + 1];
//
//                for(index = 0; index <= length; ++index) {
//                    this.anIntArray2185[index] = stream.readUnsignedShort();
//                    if(this.anIntArray2185[index] == '\uffff') {
//                        this.anIntArray2185[index] = -1;
//                    }
//                }
//
//            } else if(107 == opcode) {
//                this.isClickable = false;
//            } else if(opcode == 109) {
//                this.aBool2170 = false;
//            } else if(opcode == 111) {
//                this.aBool2190 = true;
//            } else if(opcode == 112) {
//                this.anInt2184 = stream.readUnsignedByte();
//            }
//        } else {
//            length = stream.readUnsignedByte();
//            this.models_2 = new int[length];
//
//            for(index = 0; index < length; ++index) {
//                this.models_2[index] = stream.readUnsignedShort();
//            }
//
//        }
//    }
//}

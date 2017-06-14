import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 11177993
   )
   int field433;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1708105969
   )
   int field434;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 745517805
   )
   int field435;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1152400497
   )
   int field436;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1800769673
   )
   int field437;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1540172375
   )
   int field438;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 96885087
   )
   int field439;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1546704269
   )
   int field440;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1278671857
   )
   int field441;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1996113857
   )
   int field442;
   @ObfuscatedName("be")
   static class71 field443;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1745297625"
   )
   void method256() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "101"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.field460 > this.field439) {
         var1.field460 = this.field439;
      }

      if(var1.field468 < this.field433) {
         var1.field468 = this.field433;
      }

      if(var1.field465 > this.field440) {
         var1.field465 = this.field440;
      }

      if(var1.field466 < this.field442) {
         var1.field466 = this.field442;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-126"
   )
   public boolean vmethod693(int var1, int var2, int var3) {
      return var1 >= this.field441 && var1 < this.field441 + this.field434?var2 >> 6 >= this.field435 && var2 >> 6 <= this.field437 && var3 >> 6 >= this.field436 && var3 >> 6 <= this.field438:false;
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(B)LRenderOverview;",
      garbageValue = "4"
   )
   static RenderOverview method259() {
      return FaceNormal.field2146;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-1"
   )
   public int[] vmethod695(int var1, int var2, int var3) {
      if(!this.vmethod693(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field439 * 64 - this.field435 * 64), this.field440 * 64 - this.field436 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "1721490041"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod713(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field435 * 64 - this.field439 * 64);
         int var4 = var2 + (this.field436 * 64 - this.field440 * 64);
         return new Coordinates(this.field441, var3, var4);
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-263452858"
   )
   static final void method263(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method4685();
         }

         if(var0 != null) {
            if(var0.field3591) {
               if(!var0.field3582 || var1 == Client.field1025) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class168.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class60.method996(16711680);
                     } else if(var9 < -6) {
                        var6 = class60.method996(16723968);
                     } else if(var9 < -3) {
                        var6 = class60.method996(16740352);
                     } else if(var9 < 0) {
                        var6 = class60.method996(16756736);
                     } else if(var9 > 9) {
                        var6 = class60.method996('\uff00');
                     } else if(var9 > 6) {
                        var6 = class60.method996(4259584);
                     } else if(var9 > 3) {
                        var6 = class60.method996(8453888);
                     } else if(var9 > 0) {
                        var6 = class60.method996(12648192);
                     } else {
                        var6 = class60.method996(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3582 && Client.field1061) {
                     Enum.addMenuEntry("Examine", class60.method996(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     Enum.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class60.method996(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field1071) {
                     if((class221.spellTargetFlags & 2) == 2) {
                        Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + class60.method996(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3582 && Client.field1061?2000:0;
                     String[] var12 = var0.actions;
                     if(Client.field1087) {
                        var12 = class10.method69(var12);
                     }

                     if(var12 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var12[var7] != null && !var12[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              Enum.addMenuEntry(var12[var7], class60.method996(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var12 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var12[var7] != null && var12[var7].equalsIgnoreCase("Attack")) {
                              short var11 = 0;
                              if(class91.field1414 != Client.field939) {
                                 if(class91.field1410 == Client.field939 || class91.field1412 == Client.field939 && var0.combatLevel > class168.localPlayer.combatLevel) {
                                    var11 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var11 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var11 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var11 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var11 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var11 + 13;
                                 }

                                 Enum.addMenuEntry(var12[var7], class60.method996(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3582 || !Client.field1061) {
                        Enum.addMenuEntry("Examine", class60.method996(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-203277119"
   )
   public boolean vmethod713(int var1, int var2) {
      return var1 >> 6 >= this.field439 && var1 >> 6 <= this.field433 && var2 >> 6 >= this.field440 && var2 >> 6 <= this.field442;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "929325107"
   )
   static final boolean method268(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class267.field3674;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            var2 = class267.field3677;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2062162233"
   )
   public void vmethod697(Buffer var1) {
      this.field441 = var1.readUnsignedByte();
      this.field434 = var1.readUnsignedByte();
      this.field435 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field437 = var1.readUnsignedShort();
      this.field438 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field433 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.method256();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-620275140"
   )
   static int method280(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class83.intStack[++class165.intStackSize - 1] = Client.field938;
         return 1;
      } else if(var0 == 5001) {
         class165.intStackSize -= 3;
         Client.field938 = class83.intStack[class165.intStackSize];
         class20.field337 = Widget.method4064(class83.intStack[class165.intStackSize + 1]);
         if(class20.field337 == null) {
            class20.field337 = class276.field3733;
         }

         Client.field1133 = class83.intStack[class165.intStackSize + 2];
         Client.secretPacketBuffer1.putOpcode(248);
         Client.secretPacketBuffer1.putByte(Client.field938);
         Client.secretPacketBuffer1.putByte(class20.field337.field3735);
         Client.secretPacketBuffer1.putByte(Client.field1133);
         return 1;
      } else {
         String var3;
         int var4;
         int var17;
         if(var0 == 5002) {
            var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            class165.intStackSize -= 2;
            var4 = class83.intStack[class165.intStackSize];
            var17 = class83.intStack[class165.intStackSize + 1];
            Client.secretPacketBuffer1.putOpcode(63);
            Client.secretPacketBuffer1.putByte(Script.method1836(var3) + 2);
            Client.secretPacketBuffer1.method3150(var3);
            Client.secretPacketBuffer1.putByte(var4 - 1);
            Client.secretPacketBuffer1.putByte(var17);
            return 1;
         } else {
            int var16;
            if(var0 == 5003) {
               class165.intStackSize -= 2;
               var16 = class83.intStack[class165.intStackSize];
               var4 = class83.intStack[class165.intStackSize + 1];
               MessageNode var25 = class92.method1724(var16, var4);
               if(var25 != null) {
                  class83.intStack[++class165.intStackSize - 1] = var25.id;
                  class83.intStack[++class165.intStackSize - 1] = var25.tick;
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var25.name != null?var25.name:"";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var25.sender != null?var25.sender:"";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var25.value != null?var25.value:"";
               } else {
                  class83.intStack[++class165.intStackSize - 1] = -1;
                  class83.intStack[++class165.intStackSize - 1] = 0;
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var16 = class83.intStack[--class165.intStackSize];
               MessageNode var28 = (MessageNode)class98.field1524.method3493((long)var16);
               if(var28 != null) {
                  class83.intStack[++class165.intStackSize - 1] = var28.type;
                  class83.intStack[++class165.intStackSize - 1] = var28.tick;
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var28.name != null?var28.name:"";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var28.sender != null?var28.sender:"";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var28.value != null?var28.value:"";
               } else {
                  class83.intStack[++class165.intStackSize - 1] = -1;
                  class83.intStack[++class165.intStackSize - 1] = 0;
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(class20.field337 == null) {
                  class83.intStack[++class165.intStackSize - 1] = -1;
               } else {
                  class83.intStack[++class165.intStackSize - 1] = class20.field337.field3735;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
               var4 = class83.intStack[--class165.intStackSize];
               String var5 = var3.toLowerCase();
               byte var6 = 0;
               if(var5.startsWith("yellow:")) {
                  var6 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var5.startsWith("red:")) {
                  var6 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var5.startsWith("green:")) {
                  var6 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var5.startsWith("cyan:")) {
                  var6 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var5.startsWith("purple:")) {
                  var6 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var5.startsWith("white:")) {
                  var6 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var5.startsWith("flash1:")) {
                  var6 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var5.startsWith("flash2:")) {
                  var6 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var5.startsWith("flash3:")) {
                  var6 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var5.startsWith("glow1:")) {
                  var6 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var5.startsWith("glow2:")) {
                  var6 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var5.startsWith("glow3:")) {
                  var6 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.field919 != 0) {
                  if(var5.startsWith("yellow:")) {
                     var6 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var6 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var6 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var6 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var6 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var6 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var6 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var6 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var6 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var6 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var6 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var6 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var5 = var3.toLowerCase();
               byte var26 = 0;
               if(var5.startsWith("wave:")) {
                  var26 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var5.startsWith("wave2:")) {
                  var26 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var5.startsWith("shake:")) {
                  var26 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var5.startsWith("scroll:")) {
                  var26 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var5.startsWith("slide:")) {
                  var26 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.field919 != 0) {
                  if(var5.startsWith("wave:")) {
                     var26 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var26 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var26 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var26 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var26 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               Client.secretPacketBuffer1.putOpcode(167);
               Client.secretPacketBuffer1.putByte(0);
               int var8 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var6);
               Client.secretPacketBuffer1.putByte(var26);
               PacketBuffer var19 = Client.secretPacketBuffer1;
               int var21 = var19.offset;
               int var27 = var3.length();
               byte[] var13 = new byte[var27];

               for(int var14 = 0; var14 < var27; ++var14) {
                  char var15 = var3.charAt(var14);
                  if(var15 > 0 && var15 < 128 || var15 >= 160 && var15 <= 255) {
                     var13[var14] = (byte)var15;
                  } else if(var15 == 8364) {
                     var13[var14] = -128;
                  } else if(var15 == 8218) {
                     var13[var14] = -126;
                  } else if(var15 == 402) {
                     var13[var14] = -125;
                  } else if(var15 == 8222) {
                     var13[var14] = -124;
                  } else if(var15 == 8230) {
                     var13[var14] = -123;
                  } else if(var15 == 8224) {
                     var13[var14] = -122;
                  } else if(var15 == 8225) {
                     var13[var14] = -121;
                  } else if(var15 == 710) {
                     var13[var14] = -120;
                  } else if(var15 == 8240) {
                     var13[var14] = -119;
                  } else if(var15 == 352) {
                     var13[var14] = -118;
                  } else if(var15 == 8249) {
                     var13[var14] = -117;
                  } else if(var15 == 338) {
                     var13[var14] = -116;
                  } else if(var15 == 381) {
                     var13[var14] = -114;
                  } else if(var15 == 8216) {
                     var13[var14] = -111;
                  } else if(var15 == 8217) {
                     var13[var14] = -110;
                  } else if(var15 == 8220) {
                     var13[var14] = -109;
                  } else if(var15 == 8221) {
                     var13[var14] = -108;
                  } else if(var15 == 8226) {
                     var13[var14] = -107;
                  } else if(var15 == 8211) {
                     var13[var14] = -106;
                  } else if(var15 == 8212) {
                     var13[var14] = -105;
                  } else if(var15 == 732) {
                     var13[var14] = -104;
                  } else if(var15 == 8482) {
                     var13[var14] = -103;
                  } else if(var15 == 353) {
                     var13[var14] = -102;
                  } else if(var15 == 8250) {
                     var13[var14] = -101;
                  } else if(var15 == 339) {
                     var13[var14] = -100;
                  } else if(var15 == 382) {
                     var13[var14] = -98;
                  } else if(var15 == 376) {
                     var13[var14] = -97;
                  } else {
                     var13[var14] = 63;
                  }
               }

               var19.method3157(var13.length);
               var19.offset += class265.field3670.method3075(var13, 0, var13.length, var19.payload, var19.offset);
               Client.secretPacketBuffer1.method3156(Client.secretPacketBuffer1.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               ISAACCipher.scriptStringStackSize -= 2;
               var3 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
               String var18 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(20);
               Client.secretPacketBuffer1.putShort(0);
               var17 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.method3150(var3);
               PacketBuffer var20 = Client.secretPacketBuffer1;
               int var7 = var20.offset;
               int var9 = var18.length();
               byte[] var10 = new byte[var9];

               for(int var11 = 0; var11 < var9; ++var11) {
                  char var12 = var18.charAt(var11);
                  if(var12 > 0 && var12 < 128 || var12 >= 160 && var12 <= 255) {
                     var10[var11] = (byte)var12;
                  } else if(var12 == 8364) {
                     var10[var11] = -128;
                  } else if(var12 == 8218) {
                     var10[var11] = -126;
                  } else if(var12 == 402) {
                     var10[var11] = -125;
                  } else if(var12 == 8222) {
                     var10[var11] = -124;
                  } else if(var12 == 8230) {
                     var10[var11] = -123;
                  } else if(var12 == 8224) {
                     var10[var11] = -122;
                  } else if(var12 == 8225) {
                     var10[var11] = -121;
                  } else if(var12 == 710) {
                     var10[var11] = -120;
                  } else if(var12 == 8240) {
                     var10[var11] = -119;
                  } else if(var12 == 352) {
                     var10[var11] = -118;
                  } else if(var12 == 8249) {
                     var10[var11] = -117;
                  } else if(var12 == 338) {
                     var10[var11] = -116;
                  } else if(var12 == 381) {
                     var10[var11] = -114;
                  } else if(var12 == 8216) {
                     var10[var11] = -111;
                  } else if(var12 == 8217) {
                     var10[var11] = -110;
                  } else if(var12 == 8220) {
                     var10[var11] = -109;
                  } else if(var12 == 8221) {
                     var10[var11] = -108;
                  } else if(var12 == 8226) {
                     var10[var11] = -107;
                  } else if(var12 == 8211) {
                     var10[var11] = -106;
                  } else if(var12 == 8212) {
                     var10[var11] = -105;
                  } else if(var12 == 732) {
                     var10[var11] = -104;
                  } else if(var12 == 8482) {
                     var10[var11] = -103;
                  } else if(var12 == 353) {
                     var10[var11] = -102;
                  } else if(var12 == 8250) {
                     var10[var11] = -101;
                  } else if(var12 == 339) {
                     var10[var11] = -100;
                  } else if(var12 == 382) {
                     var10[var11] = -98;
                  } else if(var12 == 376) {
                     var10[var11] = -97;
                  } else {
                     var10[var11] = 63;
                  }
               }

               var20.method3157(var10.length);
               var20.offset += class265.field3670.method3075(var10, 0, var10.length, var20.payload, var20.offset);
               Client.secretPacketBuffer1.method3155(Client.secretPacketBuffer1.offset - var17);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class83.intStack[++class165.intStackSize - 1] = Client.field1133;
                  return 1;
               } else if(var0 == 5017) {
                  var16 = class83.intStack[--class165.intStackSize];
                  class83.intStack[++class165.intStackSize - 1] = class47.method688(var16);
                  return 1;
               } else if(var0 == 5018) {
                  var16 = class83.intStack[--class165.intStackSize];
                  class83.intStack[++class165.intStackSize - 1] = class182.method3431(var16);
                  return 1;
               } else if(var0 == 5019) {
                  var16 = class83.intStack[--class165.intStackSize];
                  class83.intStack[++class165.intStackSize - 1] = class31.method283(var16);
                  return 1;
               } else if(var0 == 5020) {
                  var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                  class174.method3358(var3);
                  return 1;
               } else if(var0 == 5021) {
                  Client.field1014 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize].toLowerCase().trim();
                  return 1;
               } else if(var0 == 5022) {
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Client.field1014;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class168.localPlayer != null && class168.localPlayer.name != null) {
                  var3 = class168.localPlayer.name;
               } else {
                  var3 = "";
               }

               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3;
               return 1;
            }
         }
      }
   }
}

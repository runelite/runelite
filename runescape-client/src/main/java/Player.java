import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1099119577
   )
   static int field900;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 100798773
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("w")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1724717307
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -572575587
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("u")
   boolean field908;
   @ObfuscatedName("r")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1232810679
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 250038529
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -374578013
   )
   @Export("team")
   int team;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 710214439
   )
   int field898;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 583971107
   )
   int field905;
   @ObfuscatedName("q")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("g")
   boolean field913;
   @ObfuscatedName("c")
   @Export("model")
   Model model;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 331440593
   )
   int field902;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 381688653
   )
   int field901;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1535032715
   )
   int field897;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1447024001
   )
   int field911;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -409414307
   )
   int field892;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2130934167
   )
   int field914;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1405560261
   )
   int field891;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 840909047
   )
   int field899;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1019776703
   )
   int field906;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 582041319
   )
   int field907;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -498198937
   )
   int field917;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1897844729
   )
   int field915;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field898 = 0;
      this.field905 = 0;
      this.field908 = false;
      this.team = 0;
      this.hidden = false;
      this.field913 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class224.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field908 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class224.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3936(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2493();
            super.field1288 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field908 && super.graphic != -1 && super.field1244 != -1) {
               var4 = Renderable.getSpotAnimType(super.graphic).method4338(super.field1244);
               if(var4 != null) {
                  var4.method2504(0, -super.field1238, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field908 && this.model != null) {
               if(Client.gameCycle >= this.field905) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field898 && Client.gameCycle < this.field905) {
                  var4 = this.model;
                  var4.method2504(this.field902 - super.x, this.field901 - this.field897, this.field892 - super.y);
                  if(super.orientation == 512) {
                     var4.method2487();
                     var4.method2487();
                     var4.method2487();
                  } else if(super.orientation == 1024) {
                     var4.method2487();
                     var4.method2487();
                  } else if(super.orientation == 1536) {
                     var4.method2487();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2487();
                  } else if(super.orientation == 1024) {
                     var4.method2487();
                     var4.method2487();
                  } else if(super.orientation == 1536) {
                     var4.method2487();
                     var4.method2487();
                     var4.method2487();
                  }

                  var4.method2504(super.x - this.field902, this.field897 - this.field901, super.y - this.field892);
               }
            }

            var3.field1950 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1703923473"
   )
   void method1176(int var1, int var2) {
      super.queueSize = 0;
      super.field1269 = 0;
      super.field1275 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "109"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class35.getNpcDefinition(this.composition.transformedNpcId).field3561:1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1641083749"
   )
   final void method1159(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1297[var4] = super.field1297[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1297[0] = var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2061214073"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1318527070"
   )
   @Export("decodeApperance")
   final void decodeApperance(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = AbstractByteBuffer.getItemDefinition(var4[var5] - 512).field3542;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1290 = var1.readUnsignedShort();
      if(super.field1290 == '\uffff') {
         super.field1290 = -1;
      }

      super.field1245 = super.field1290;
      super.field1246 = var1.readUnsignedShort();
      if(super.field1246 == '\uffff') {
         super.field1246 = -1;
      }

      super.field1283 = var1.readUnsignedShort();
      if(super.field1283 == '\uffff') {
         super.field1283 = -1;
      }

      super.field1270 = var1.readUnsignedShort();
      if(super.field1270 == '\uffff') {
         super.field1270 = -1;
      }

      super.field1249 = var1.readUnsignedShort();
      if(super.field1249 == '\uffff') {
         super.field1249 = -1;
      }

      super.field1250 = var1.readUnsignedShort();
      if(super.field1250 == '\uffff') {
         super.field1250 = -1;
      }

      this.name = var1.readString();
      if(this == XItemContainer.localPlayer) {
         class152.field2234 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.totalLevel = var1.readUnsignedShort();
      this.hidden = var1.readUnsignedByte() == 1;
      if(Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3962(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "-13210"
   )
   final void method1158(int var1, int var2, byte var3) {
      if(super.animation != -1 && class224.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1266 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.getSize();
                  Client.field1204.field2325 = var1;
                  Client.field1204.field2323 = var2;
                  Client.field1204.field2324 = 1;
                  Client.field1204.field2322 = 1;
                  class73 var11 = Client.field1204;
                  int var12 = ChatLineBuffer.method1883(var5, var6, var10, var11, Client.collisionMaps[this.field911], true, Client.field1205, Client.field1053);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method1159(Client.field1205[var13], Client.field1053[var13], (byte)2);
                     }
                  }
               }
            }

            this.method1159(var1, var2, var3);
         } else {
            this.method1176(var1, var2);
         }
      } else {
         this.method1176(var1, var2);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;S)Ljava/lang/String;",
      garbageValue = "15640"
   )
   public static String method1179(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && PacketBuffer.method3402(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && PacketBuffer.method3402(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3859) {
               case 4:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var13 = new StringBuilder(var4);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else {
                     boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     if(var9) {
                        var8 = true;
                     } else {
                        char[] var14 = class267.field3674;
                        int var11 = 0;

                        label108:
                        while(true) {
                           char var12;
                           if(var11 >= var14.length) {
                              var14 = class267.field3677;

                              for(var11 = 0; var11 < var14.length; ++var11) {
                                 var12 = var14[var11];
                                 if(var7 == var12) {
                                    var8 = true;
                                    break label108;
                                 }
                              }

                              var8 = false;
                              break;
                           }

                           var12 = var14[var11];
                           if(var7 == var12) {
                              var8 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var8) {
                     char var16;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var16 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var16 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var16 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var16 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var16 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var16 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var16 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var16 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var16 = 117;
                        break;
                     case 'ß':
                        var16 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var16 = 121;
                        break;
                     default:
                        var16 = Character.toLowerCase(var7);
                     }

                     if(var16 != 0) {
                        var13.append(var16);
                     }
                  }
               }

               if(var13.length() == 0) {
                  return null;
               }

               return var13.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1480727916"
   )
   public static void method1177() {
      try {
         File var0 = new File(GraphicsObject.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.field2258 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var4 = 0; var4 < FaceNormal.field2153.length; ++var4) {
               for(var2 = 0; var2 < class37.cacheLocations.length; ++var2) {
                  File var3 = new File(class37.cacheLocations[var2] + FaceNormal.field2153[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.field2258 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class155.field2258 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class155.field2258 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "223102704"
   )
   public static void method1175(String var0, boolean var1, boolean var2) {
      class18.method131(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)V",
      garbageValue = "-3"
   )
   public static void method1178(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3380 = var0;
      CombatInfo2.field3373 = var1;
   }
}

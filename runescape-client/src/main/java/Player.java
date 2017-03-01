import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1688090303
   )
   int field240;
   @ObfuscatedName("n")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("z")
   boolean field242;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -588889473
   )
   int field244;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -582407433
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -274703519
   )
   int field246;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 13980319
   )
   int field247;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 551020567
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1070372143
   )
   int field249;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1306032673
   )
   int field250;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 767935937
   )
   int field251;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -382978279
   )
   int field252;
   @ObfuscatedName("q")
   @Export("model")
   Model model;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -34772607
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1943313065
   )
   int field255;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 695129081
   )
   int field256;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1760083185
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("r")
   boolean field258;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -3570445
   )
   @Export("team")
   int team;
   @ObfuscatedName("e")
   boolean field260;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1166052621
   )
   int field261;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2059499471
   )
   int field262;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 661836511
   )
   static int field263;
   @ObfuscatedName("p")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1242111981
   )
   int field265;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 2144553633
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("dv")
   static byte[][] field267;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -239386795
   )
   int field268;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 647719633
   )
   static int field269;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "917331213"
   )
   final void method228(Buffer var1) {
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
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = ChatLineBuffer.getItemDefinition(var4[var5] - 512).field2950;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class164.field2159[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field610 = var1.readUnsignedShort();
      if(super.field610 == '\uffff') {
         super.field610 = -1;
      }

      super.field621 = super.field610;
      super.field632 = var1.readUnsignedShort();
      if(super.field632 == '\uffff') {
         super.field632 = -1;
      }

      super.field612 = var1.readUnsignedShort();
      if(super.field612 == '\uffff') {
         super.field612 = -1;
      }

      super.field603 = var1.readUnsignedShort();
      if(super.field603 == '\uffff') {
         super.field603 = -1;
      }

      super.field614 = var1.readUnsignedShort();
      if(super.field614 == '\uffff') {
         super.field614 = -1;
      }

      super.field615 = var1.readUnsignedShort();
      if(super.field615 == '\uffff') {
         super.field615 = -1;
      }

      this.name = var1.readString();
      if(this == WidgetNode.localPlayer) {
         class101.field1658 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field240 = var1.readUnsignedShort();
      this.field260 = var1.readUnsignedByte() == 1;
      if(Client.field309 == 0 && Client.field425 >= 2) {
         this.field260 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3270(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "615330587"
   )
   final void method231(int var1, int var2, byte var3) {
      if(super.animation != -1 && TextureProvider.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field631 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               GroundObject.method1625(this, var1, var2, (byte)2);
            }

            this.method245(var1, var2, var3);
         } else {
            this.method233(var1, var2);
         }
      } else {
         this.method233(var1, var2);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-963198739"
   )
   int method232() {
      return null != this.composition && this.composition.field2171 != -1?class159.getNpcDefinition(this.composition.field2171).field3040:1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-901715569"
   )
   void method233(int var1, int var2) {
      super.field657 = 0;
      super.field662 = 0;
      super.field661 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method232();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = 128 * super.pathY[0] + 64 * var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-58"
   )
   public static boolean method234() {
      long var0 = WallObject.method1985();
      int var2 = (int)(var0 - class185.field2748);
      class185.field2748 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2764 += var2;
      if(class185.field2751 == 0 && class185.field2752 == 0 && class185.field2755 == 0 && class185.field2750 == 0) {
         return true;
      } else if(class185.field2757 == null) {
         return false;
      } else {
         try {
            if(class185.field2764 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2752 < 20 && class185.field2750 > 0) {
                  var3 = (class181)class185.field2749.method2440();
                  var4 = new Buffer(4);
                  var4.method2873(1);
                  var4.method2871((int)var3.hash);
                  class185.field2757.method2148(var4.payload, 0, 4);
                  class185.field2766.method2438(var3, var3.hash);
                  --class185.field2750;
                  ++class185.field2752;
               }

               while(class185.field2751 < 20 && class185.field2755 > 0) {
                  var3 = (class181)class185.field2756.method2392();
                  var4 = new Buffer(4);
                  var4.method2873(0);
                  var4.method2871((int)var3.hash);
                  class185.field2757.method2148(var4.payload, 0, 4);
                  var3.method2513();
                  class185.field2759.method2438(var3, var3.hash);
                  --class185.field2755;
                  ++class185.field2751;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2757.method2138();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2764 = 0;
                  byte var5 = 0;
                  if(class210.field3130 == null) {
                     var5 = 8;
                  } else if(class185.field2746 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2758.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2757.method2143(class185.field2758.payload, class185.field2758.offset, var6);
                     if(class185.field2763 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2758.payload[class185.field2758.offset + var7] ^= class185.field2763;
                        }
                     }

                     class185.field2758.offset += var6;
                     if(class185.field2758.offset < var5) {
                        break;
                     }

                     if(class210.field3130 == null) {
                        class185.field2758.offset = 0;
                        var7 = class185.field2758.readUnsignedByte();
                        var8 = class185.field2758.readUnsignedShort();
                        int var9 = class185.field2758.readUnsignedByte();
                        var10 = class185.field2758.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        class181 var13 = (class181)class185.field2766.method2437(var11);
                        class25.field587 = true;
                        if(null == var13) {
                           var13 = (class181)class185.field2759.method2437(var11);
                           class25.field587 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class210.field3130 = var13;
                        ChatMessages.field939 = new Buffer(var14 + var10 + class210.field3130.field2707);
                        ChatMessages.field939.method2873(var9);
                        ChatMessages.field939.method2874(var10);
                        class185.field2746 = 8;
                        class185.field2758.offset = 0;
                     } else if(class185.field2746 == 0) {
                        if(class185.field2758.payload[0] == -1) {
                           class185.field2746 = 1;
                           class185.field2758.offset = 0;
                        } else {
                           class210.field3130 = null;
                        }
                     }
                  } else {
                     var6 = ChatMessages.field939.payload.length - class210.field3130.field2707;
                     var7 = 512 - class185.field2746;
                     if(var7 > var6 - ChatMessages.field939.offset) {
                        var7 = var6 - ChatMessages.field939.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2757.method2143(ChatMessages.field939.payload, ChatMessages.field939.offset, var7);
                     if(class185.field2763 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           ChatMessages.field939.payload[ChatMessages.field939.offset + var8] ^= class185.field2763;
                        }
                     }

                     ChatMessages.field939.offset += var7;
                     class185.field2746 += var7;
                     if(ChatMessages.field939.offset == var6) {
                        if(class210.field3130.hash == 16711935L) {
                           class185.field2762 = ChatMessages.field939;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2760[var8];
                              if(null != var17) {
                                 class185.field2762.offset = var8 * 8 + 5;
                                 var10 = class185.field2762.readInt();
                                 int var18 = class185.field2762.readInt();
                                 var17.method3446(var10, var18);
                              }
                           }
                        } else {
                           class185.field2761.reset();
                           class185.field2761.update(ChatMessages.field939.payload, 0, var6);
                           var8 = (int)class185.field2761.getValue();
                           if(var8 != class210.field3130.field2702) {
                              try {
                                 class185.field2757.method2139();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class185.field2765;
                              class185.field2757 = null;
                              class185.field2763 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2765 = 0;
                           class185.field2747 = 0;
                           class210.field3130.field2704.method3447((int)(class210.field3130.hash & 65535L), ChatMessages.field939.payload, (class210.field3130.hash & 16711680L) == 16711680L, class25.field587);
                        }

                        class210.field3130.unlink();
                        if(class25.field587) {
                           --class185.field2752;
                        } else {
                           --class185.field2751;
                        }

                        class185.field2746 = 0;
                        class210.field3130 = null;
                        ChatMessages.field939 = null;
                     } else {
                        if(class185.field2746 != 512) {
                           break;
                        }

                        class185.field2746 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class185.field2757.method2139();
            } catch (Exception var19) {
               ;
            }

            ++class185.field2747;
            class185.field2757 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1273886024"
   )
   public static int method237(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?TextureProvider.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field258 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?TextureProvider.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3242(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1649();
            super.field653 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field258 && super.graphic != -1 && super.field648 != -1) {
               var4 = class157.method3129(super.graphic).method3535(super.field648);
               if(null != var4) {
                  var4.method1694(0, -super.field616, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field258 && null != this.model) {
               if(Client.gameCycle >= this.field249) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field249) {
                  var4 = this.model;
                  var4.method1694(this.field246 - super.x, this.field268 - this.field247, this.field252 - super.y);
                  if(super.field654 == 512) {
                     var4.method1718();
                     var4.method1718();
                     var4.method1718();
                  } else if(super.field654 == 1024) {
                     var4.method1718();
                     var4.method1718();
                  } else if(super.field654 == 1536) {
                     var4.method1718();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field654 == 512) {
                     var4.method1718();
                  } else if(super.field654 == 1024) {
                     var4.method1718();
                     var4.method1718();
                  } else if(super.field654 == 1536) {
                     var4.method1718();
                     var4.method1718();
                     var4.method1718();
                  }

                  var4.method1694(super.x - this.field246, this.field247 - this.field268, super.y - this.field252);
               }
            }

            var3.field1388 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "2114052936"
   )
   final void method245(int var1, int var2, byte var3) {
      if(super.field657 < 9) {
         ++super.field657;
      }

      for(int var4 = super.field657; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field609[var4] = super.field609[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field609[0] = var3;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field240 = 0;
      this.totalLevel = 0;
      this.field249 = 0;
      this.field258 = false;
      this.team = 0;
      this.field260 = false;
      this.field242 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "466855216"
   )
   final boolean vmethod794() {
      return this.composition != null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "50014155"
   )
   public static boolean method255(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-1771814078"
   )
   public static void method258(class182 var0, class182 var1, class182 var2, class182 var3) {
      Widget.field2197 = var0;
      Widget.field2198 = var1;
      Widget.field2223 = var2;
      class155.field2106 = var3;
      class231.widgets = new Widget[Widget.field2197.method3366()][];
      Widget.validInterfaces = new boolean[Widget.field2197.method3366()];
   }
}

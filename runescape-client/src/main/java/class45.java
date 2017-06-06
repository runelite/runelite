import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class45 extends class28 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1511366625
   )
   int field586;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1825998579
   )
   int field587;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1630171133
   )
   int field588;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1120565869
   )
   int field589;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "394450613"
   )
   void method612(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field505.field509) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedByte();
         super.field409 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         this.field587 = var2.readUnsignedByte();
         this.field588 = var2.readUnsignedByte();
         super.field408 = var2.readUnsignedShort();
         super.field415 = var2.readUnsignedShort();
         this.field586 = var2.readUnsignedByte();
         this.field589 = var2.readUnsignedByte();
         super.field411 = Math.min(super.field411, 4);
         super.field412 = new short[1][64][64];
         super.field413 = new short[super.field411][64][64];
         super.field407 = new byte[super.field411][64][64];
         super.field406 = new byte[super.field411][64][64];
         super.field416 = new class31[super.field411][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field496.field497) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(super.field408 == var4 && super.field415 == var5 && var6 == this.field586 && this.field589 == var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method227(this.field586 * 8 + var8, this.field589 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;I)V",
      garbageValue = "-1503235512"
   )
   static void method614(Font var0, Font var1) {
      if(class21.field332 == null) {
         class21.field332 = class162.method3053(class261.indexSprites, "sl_back", "");
      }

      if(class73.field887 == null) {
         class73.field887 = class164.method3071(class261.indexSprites, "sl_flags", "");
      }

      if(class9.field249 == null) {
         class9.field249 = class164.method3071(class261.indexSprites, "sl_arrows", "");
      }

      if(class14.field285 == null) {
         class14.field285 = class164.method3071(class261.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method4923(class92.field1459, 23, 765, 480, 0);
      Rasterizer2D.method4987(class92.field1459, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4987(class92.field1459 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4736("Select a world", class92.field1459 + 62, 15, 0, -1);
      if(class14.field285 != null) {
         class14.field285[1].method5017(class92.field1459 + 140, 1);
         var1.method4737("Members only world", class92.field1459 + 152, 10, 16777215, -1);
         class14.field285[0].method5017(class92.field1459 + 140, 12);
         var1.method4737("Free world", class92.field1459 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class9.field249 != null) {
         int var2 = class92.field1459 + 280;
         if(World.field1328[0] == 0 && World.field1318[0] == 0) {
            class9.field249[2].method5017(var2, 4);
         } else {
            class9.field249[0].method5017(var2, 4);
         }

         if(World.field1328[0] == 0 && World.field1318[0] == 1) {
            class9.field249[3].method5017(var2 + 15, 4);
         } else {
            class9.field249[1].method5017(var2 + 15, 4);
         }

         var0.method4737("World", var2 + 32, 17, 16777215, -1);
         int var3 = class92.field1459 + 390;
         if(World.field1328[0] == 1 && World.field1318[0] == 0) {
            class9.field249[2].method5017(var3, 4);
         } else {
            class9.field249[0].method5017(var3, 4);
         }

         if(World.field1328[0] == 1 && World.field1318[0] == 1) {
            class9.field249[3].method5017(var3 + 15, 4);
         } else {
            class9.field249[1].method5017(var3 + 15, 4);
         }

         var0.method4737("Players", var3 + 32, 17, 16777215, -1);
         var4 = class92.field1459 + 500;
         if(World.field1328[0] == 2 && World.field1318[0] == 0) {
            class9.field249[2].method5017(var4, 4);
         } else {
            class9.field249[0].method5017(var4, 4);
         }

         if(World.field1328[0] == 2 && World.field1318[0] == 1) {
            class9.field249[3].method5017(var4 + 15, 4);
         } else {
            class9.field249[1].method5017(var4 + 15, 4);
         }

         var0.method4737("Location", var4 + 32, 17, 16777215, -1);
         var5 = class92.field1459 + 610;
         if(World.field1328[0] == 3 && World.field1318[0] == 0) {
            class9.field249[2].method5017(var5, 4);
         } else {
            class9.field249[0].method5017(var5, 4);
         }

         if(World.field1328[0] == 3 && World.field1318[0] == 1) {
            class9.field249[3].method5017(var5 + 15, 4);
         } else {
            class9.field249[1].method5017(var5 + 15, 4);
         }

         var0.method4737("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4923(class92.field1459 + 708, 4, 50, 16, 0);
      var1.method4736("Cancel", class92.field1459 + 708 + 25, 16, 16777215, -1);
      class92.field1469 = -1;
      if(class21.field332 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field1326) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field1326) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.field1326) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var22 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class92.field1459;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field1326; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1551()) {
               if(var15.method1567()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1550()) {
               var19 = 16711680;
               if(var15.method1567()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1548()) {
               if(var15.method1567()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1567()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class59.field737 >= var11 && class59.field738 >= var10 && class59.field737 < var21 + var11 && class59.field738 < var10 + var22 && var16) {
               class92.field1469 = var14;
               class21.field332[var18].method5050(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class21.field332[var18].method5045(var11, var10);
            }

            if(class73.field887 != null) {
               class73.field887[(var15.method1567()?8:0) + var15.location].method5017(var11 + 29, var10);
            }

            var0.method4736(Integer.toString(var15.id), var11 + 15, var10 + var22 / 2 + 5, var19, -1);
            var1.method4736(var17, var11 + 60, var10 + var22 / 2 + 5, 268435455, -1);
            var10 += var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4728(World.worldList[class92.field1469].activity) + 6;
            int var20 = var1.field3652 + 8;
            Rasterizer2D.method4923(class59.field737 - var14 / 2, class59.field738 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.method4945(class59.field737 - var14 / 2, class59.field738 + 20 + 5, var14, var20, 0);
            var1.method4736(World.worldList[class92.field1469].activity, class59.field737, class59.field738 + 20 + 5 + var1.field3652 + 4, 0, -1);
         }
      }

      class166.field2343.vmethod5008(0, 0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-22667"
   )
   int method617() {
      return this.field588;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "32767"
   )
   int method618() {
      return this.field586;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1172842632"
   )
   int method619() {
      return this.field589;
   }

   public int hashCode() {
      return super.field408 | super.field415 << 8 | this.field586 << 16 | this.field589 << 24;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-842884016"
   )
   boolean method628(int var1, int var2) {
      return var1 < this.field586 * 8?false:(var2 < this.field589 * 8?false:(var1 >= this.field586 * 8 + 8?false:var2 < this.field589 * 8 + 8));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1672045011"
   )
   int method639() {
      return this.field587;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field408 == var2.field408 && super.field415 == var2.field415?var2.field586 == this.field586 && var2.field589 == this.field589:false;
      }
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1924840906"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         int var1 = Client.secretPacketBuffer2.method3176();
         var2 = Client.secretPacketBuffer2.method3176();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         ChatLineBuffer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               ChatLineBuffer.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class100.mapRegions = new int[var3];
         XItemContainer.field794 = new int[var3];
         class28.field420 = new int[var3];
         XClanMember.field923 = new byte[var3][];
         Frames.field2158 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class100.mapRegions[var3] = var7;
                  XItemContainer.field794[var3] = XClanMember.indexMaps.method4125("m" + var5 + "_" + var6);
                  class28.field420[var3] = XClanMember.indexMaps.method4125("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Frames.method2874(var1, var2, true);
      } else {
         boolean var14 = Client.secretPacketBuffer2.method3169() == 1;
         var2 = Client.secretPacketBuffer2.readUnsignedShort();
         var3 = Client.secretPacketBuffer2.method3178();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.method3389();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3397(1);
                  if(var8 == 1) {
                     Client.field992[var5][var6][var7] = Client.secretPacketBuffer2.method3397(26);
                  } else {
                     Client.field992[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.method3391();
         ChatLineBuffer.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               ChatLineBuffer.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class100.mapRegions = new int[var4];
         XItemContainer.field794 = new int[var4];
         class28.field420 = new int[var4];
         XClanMember.field923 = new byte[var4][];
         Frames.field2158 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field992[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(var11 == class100.mapRegions[var12]) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class100.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        XItemContainer.field794[var4] = XClanMember.indexMaps.method4125("m" + var12 + "_" + var13);
                        class28.field420[var4] = XClanMember.indexMaps.method4125("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         Frames.method2874(var2, var3, !var14);
      }

   }
}

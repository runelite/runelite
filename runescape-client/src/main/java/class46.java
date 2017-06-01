import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class46 {
   @ObfuscatedName("c")
   byte[][][] field596;
   @ObfuscatedName("ci")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -397986513
   )
   int field603;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1564314064"
   )
   void method645(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field603 != 0 && this.field596 != null) {
         var8 = this.method646(var8, var7);
         var7 = this.method659(var7);
         Rasterizer2D.method4929(var1, var2, var5, var6, var3, var4, this.field596[var7 - 1][var8], this.field603);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1258162469"
   )
   int method646(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2080266628"
   )
   void method648() {
      byte[] var1 = new byte[this.field603 * this.field603];
      boolean var2 = false;
      var1 = new byte[this.field603 * this.field603];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[7][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[7][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[7][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[7][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-923623354"
   )
   static int method649(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class232.field3187:class2.field15;
      }

      class25.method169(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class83.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = World.localPlayer.composition.method3944();
            return 1;
         } else {
            return 2;
         }
      } else {
         class83.intStackSize -= 2;
         int var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = Buffer.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2700 = var6.offsetX2d;
         var3.field2701 = var6.offsetY2d;
         var3.field2705 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2709 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2709 = 1;
         } else {
            var3.field2709 = 2;
         }

         if(var3.field2743 > 0) {
            var3.field2705 = var3.field2705 * 32 / var3.field2743;
         } else if(var3.originalWidth > 0) {
            var3.field2705 = var3.field2705 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2114250169"
   )
   void method650() {
      byte[] var1 = new byte[this.field603 * this.field603];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[1][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field596[1][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[1][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[1][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   void method651() {
      byte[] var1 = new byte[this.field603 * this.field603];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[2][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[2][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[2][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[2][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383620036"
   )
   void method652() {
      byte[] var1 = new byte[this.field603 * this.field603];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[3][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[3][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[3][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[3][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method653() {
      byte[] var1 = new byte[this.field603 * this.field603];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[4][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[4][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[4][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[4][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1012328307"
   )
   void method655() {
      byte[] var1 = new byte[this.field603 * this.field603];
      boolean var2 = false;
      var1 = new byte[this.field603 * this.field603];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[6][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[6][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[6][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = this.field603 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[6][3] = var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "61"
   )
   public static void method658(boolean var0) {
      if(var0 != class134.isMembersWorld) {
         ItemComposition.field3487.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         class134.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1540138259"
   )
   int method659(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1315210879"
   )
   void method675() {
      byte[] var1 = new byte[this.field603 * this.field603];
      boolean var2 = false;
      var1 = new byte[this.field603 * this.field603];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[5][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var3 <= this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[5][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[5][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var5 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var3 >= this.field603 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field596[5][3] = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1730447583"
   )
   void method686() {
      if(this.field596 == null) {
         this.field596 = new byte[8][4][];
         this.method688();
         this.method650();
         this.method651();
         this.method652();
         this.method653();
         this.method675();
         this.method655();
         this.method648();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1050485751"
   )
   void method688() {
      byte[] var1 = new byte[this.field603 * this.field603];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[0][0] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[0][1] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = 0; var3 < this.field603; ++var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[0][2] = var1;
      var1 = new byte[this.field603 * this.field603];
      var2 = 0;

      for(var3 = this.field603 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field603; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field596[0][3] = var1;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1756019228"
   )
   static final void method689(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1133; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field1135[var4] = true;
         }
      }

   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-172638733"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 17) {
         Client.field1175 = var6;
         Client.field1038 = var7;
         Client.field1186 = 2;
         Client.field1000 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(149);
         Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
         Client.secretPacketBuffer1.putShort(Client.field1086);
         Client.secretPacketBuffer1.method3175(var0 + class41.baseX);
         Client.secretPacketBuffer1.method3283(ChatMessages.field1528);
         Client.secretPacketBuffer1.method3132(var3);
         Client.secretPacketBuffer1.method3227(WorldMapType3.baseY + var1);
      }

      if(var2 == 26) {
         WorldMapType1.method260();
      }

      if(var2 == 39) {
         Client.secretPacketBuffer1.putOpcode(180);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3183(var1);
         Client.secretPacketBuffer1.putShort(var0);
         Client.field932 = 0;
         class47.field614 = WorldMapType3.method199(var1);
         Client.field1035 = var0;
      }

      NPC var8;
      if(var2 == 1003) {
         Client.field1175 = var6;
         Client.field1038 = var7;
         Client.field1186 = 2;
         Client.field1000 = 0;
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            NPCComposition var9 = var8.composition;
            if(var9.configs != null) {
               var9 = var9.method4652();
            }

            if(var9 != null) {
               Client.secretPacketBuffer1.putOpcode(136);
               Client.secretPacketBuffer1.method3132(var9.id);
            }
         }
      }

      if(var2 == 30 && Client.field963 == null) {
         class230.method4093(var1, var0);
         Client.field963 = FileOnDisk.method2351(var1, var0);
         class25.method169(Client.field963);
      }

      Player var20;
      if(var2 == 48) {
         var20 = Client.cachedPlayers[var3];
         if(var20 != null) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(192);
            Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
            Client.secretPacketBuffer1.method3227(var3);
         }
      }

      Widget var21;
      if(var2 == 58) {
         var21 = FileOnDisk.method2351(var1, var0);
         if(var21 != null) {
            Client.secretPacketBuffer1.putOpcode(206);
            Client.secretPacketBuffer1.method3283(ChatMessages.field1528);
            Client.secretPacketBuffer1.method3227(Client.field1086);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3132(var21.itemId);
            Client.secretPacketBuffer1.method3175(Client.field1174);
         }
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(124);
         Client.secretPacketBuffer1.method3227(var3);
         Client.secretPacketBuffer1.method3153(var1);
         Client.secretPacketBuffer1.method3227(var0);
         Client.field932 = 0;
         class47.field614 = WorldMapType3.method199(var1);
         Client.field1035 = var0;
      }

      if(var2 == 2) {
         Client.field1175 = var6;
         Client.field1038 = var7;
         Client.field1186 = 2;
         Client.field1000 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(55);
         Client.secretPacketBuffer1.method3153(ChatMessages.field1528);
         Client.secretPacketBuffer1.method3175(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
         Client.secretPacketBuffer1.putShort(Client.field1086);
         Client.secretPacketBuffer1.putShort(WorldMapType3.baseY + var1);
         Client.secretPacketBuffer1.method3175(class41.baseX + var0);
      }

      if(var2 == 19) {
         Client.field1175 = var6;
         Client.field1038 = var7;
         Client.field1186 = 2;
         Client.field1000 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(251);
         Client.secretPacketBuffer1.method3132(var3);
         Client.secretPacketBuffer1.method3132(class41.baseX + var0);
         Client.secretPacketBuffer1.putShort(var1 + WorldMapType3.baseY);
         Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
      }

      int var16;
      if(var2 == 25) {
         var21 = FileOnDisk.method2351(var1, var0);
         if(var21 != null) {
            class9.method39();
            int var10 = class210.method3903(var21);
            var16 = var10 >> 11 & 63;
            int var12 = var21.itemId;
            Widget var13 = FileOnDisk.method2351(var1, var0);
            if(var13 != null && var13.field2773 != null) {
               class69 var14 = new class69();
               var14.field852 = var13;
               var14.field849 = var13.field2773;
               Friend.method1075(var14);
            }

            Client.field1174 = var12;
            Client.field1085 = true;
            ChatMessages.field1528 = var1;
            Client.field1086 = var0;
            class64.field808 = var16;
            class25.method169(var13);
            Client.field1083 = 0;
            int var15 = class210.method3903(var21);
            int var17 = var15 >> 11 & 63;
            String var22;
            if(var17 == 0) {
               var22 = null;
            } else if(var21.field2730 != null && var21.field2730.trim().length() != 0) {
               var22 = var21.field2730;
            } else {
               var22 = null;
            }

            Client.field1088 = var22;
            if(Client.field1088 == null) {
               Client.field1088 = "Null";
            }

            if(var21.hasScript) {
               Client.field1089 = var21.name + WorldMapData.method337(16777215);
            } else {
               Client.field1089 = WorldMapData.method337('\uff00') + var21.field2767 + WorldMapData.method337(16777215);
            }
         }

      } else {
         if(var2 == 31) {
            Client.secretPacketBuffer1.putOpcode(103);
            Client.secretPacketBuffer1.putShort(IndexFile.field2303);
            Client.secretPacketBuffer1.method3183(var1);
            Client.secretPacketBuffer1.method3175(var3);
            Client.secretPacketBuffer1.method3153(GameObject.field2212);
            Client.secretPacketBuffer1.method3175(var0);
            Client.secretPacketBuffer1.putShort(class109.field1645);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 44) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(181);
               Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3227(var3);
            }
         }

         if(var2 == 22) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(100);
            Client.secretPacketBuffer1.method3227(var3);
            Client.secretPacketBuffer1.method3132(WorldMapType3.baseY + var1);
            Client.secretPacketBuffer1.method3132(class41.baseX + var0);
            Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
         }

         if(var2 == 1002) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.secretPacketBuffer1.putOpcode(155);
            Client.secretPacketBuffer1.method3227(var3 >> 14 & 32767);
         }

         if(var2 == 46) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(62);
               Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3175(var3);
            }
         }

         if(var2 == 5) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(184);
            Client.secretPacketBuffer1.method3175(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
            Client.secretPacketBuffer1.method3175(class41.baseX + var0);
            Client.secretPacketBuffer1.putShort(WorldMapType3.baseY + var1);
         }

         if(var2 == 50) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(85);
               Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3132(var3);
            }
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(173);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3183(var1);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 36) {
            Client.secretPacketBuffer1.putOpcode(21);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3183(var1);
            Client.secretPacketBuffer1.putShort(var3);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 32) {
            Client.secretPacketBuffer1.putOpcode(28);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3283(ChatMessages.field1528);
            Client.secretPacketBuffer1.putShort(Client.field1086);
            Client.secretPacketBuffer1.method3132(var0);
            Client.secretPacketBuffer1.method3227(var3);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 20) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(19);
            Client.secretPacketBuffer1.method3227(var1 + WorldMapType3.baseY);
            Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3132(var0 + class41.baseX);
         }

         if(var2 == 21) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(36);
            Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
            Client.secretPacketBuffer1.method3175(class41.baseX + var0);
            Client.secretPacketBuffer1.method3227(var1 + WorldMapType3.baseY);
            Client.secretPacketBuffer1.putShort(var3);
         }

         if(var2 == 1004) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.secretPacketBuffer1.putOpcode(20);
            Client.secretPacketBuffer1.method3175(var3);
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            class1.field14.method5223(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 45) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(224);
               Client.secretPacketBuffer1.method3165(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3132(var3);
            }
         }

         if(var2 == 41) {
            Client.secretPacketBuffer1.putOpcode(243);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3175(var3);
            Client.secretPacketBuffer1.method3227(var0);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 28) {
            Client.secretPacketBuffer1.putOpcode(130);
            Client.secretPacketBuffer1.putInt(var1);
            var21 = WorldMapType3.method199(var1);
            if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
               var16 = var21.dynamicValues[0][1];
               class211.widgetSettings[var16] = 1 - class211.widgetSettings[var16];
               class10.method47(var16);
            }
         }

         if(var2 == 49) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(24);
               Client.secretPacketBuffer1.method3227(var3);
               Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
            }
         }

         if(var2 == 42) {
            Client.secretPacketBuffer1.putOpcode(73);
            Client.secretPacketBuffer1.method3227(var3);
            Client.secretPacketBuffer1.method3227(var0);
            Client.secretPacketBuffer1.method3283(var1);
            Client.field932 = 0;
            class47.field614 = WorldMapType3.method199(var1);
            Client.field1035 = var0;
         }

         if(var2 == 15) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(44);
               Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3283(ChatMessages.field1528);
               Client.secretPacketBuffer1.method3227(var3);
               Client.secretPacketBuffer1.putShort(Client.field1086);
            }
         }

         if(var2 == 51) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(13);
               Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3132(var3);
            }
         }

         if(var2 == 6) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(172);
            Client.secretPacketBuffer1.method3175(var1 + WorldMapType3.baseY);
            Client.secretPacketBuffer1.putShort(class41.baseX + var0);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3165(class50.field645[82]?1:0);
         }

         if(var2 == 4) {
            Client.field1175 = var6;
            Client.field1038 = var7;
            Client.field1186 = 2;
            Client.field1000 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(113);
            Client.secretPacketBuffer1.method3132(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(var1 + WorldMapType3.baseY);
            Client.secretPacketBuffer1.method3165(class50.field645[82]?1:0);
            Client.secretPacketBuffer1.putShort(class41.baseX + var0);
         }

         if(var2 == 38) {
            class9.method39();
            var21 = WorldMapType3.method199(var1);
            Client.field1083 = 1;
            IndexFile.field2303 = var0;
            GameObject.field2212 = var1;
            class109.field1645 = var3;
            class25.method169(var21);
            Client.field1084 = WorldMapData.method337(16748608) + Buffer.getItemDefinition(var3).name + WorldMapData.method337(16777215);
            if(Client.field1084 == null) {
               Client.field1084 = "null";
            }

         } else {
            if(var2 == 24) {
               var21 = WorldMapType3.method199(var1);
               boolean var23 = true;
               if(var21.contentType > 0) {
                  var23 = class33.method340(var21);
               }

               if(var23) {
                  Client.secretPacketBuffer1.putOpcode(130);
                  Client.secretPacketBuffer1.putInt(var1);
               }
            }

            if(var2 == 12) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(242);
                  Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3227(var3);
               }
            }

            if(var2 == 3) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(211);
               Client.secretPacketBuffer1.method3175(WorldMapType3.baseY + var1);
               Client.secretPacketBuffer1.method3227(var0 + class41.baseX);
               Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            }

            if(var2 == 1001) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(191);
               Client.secretPacketBuffer1.method3175(WorldMapType3.baseY + var1);
               Client.secretPacketBuffer1.method3175(class41.baseX + var0);
               Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            }

            if(var2 == 37) {
               Client.secretPacketBuffer1.putOpcode(248);
               Client.secretPacketBuffer1.method3153(var1);
               Client.secretPacketBuffer1.method3175(var3);
               Client.secretPacketBuffer1.method3132(var0);
               Client.field932 = 0;
               class47.field614 = WorldMapType3.method199(var1);
               Client.field1035 = var0;
            }

            if(var2 == 11) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(2);
                  Client.secretPacketBuffer1.method3165(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3227(var3);
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var21 = FileOnDisk.method2351(var1, var0);
               if(var21 != null) {
                  var16 = var21.itemId;
                  Widget var18 = FileOnDisk.method2351(var1, var0);
                  if(var18 != null) {
                     if(var18.field2751 != null) {
                        class69 var19 = new class69();
                        var19.field852 = var18;
                        var19.field853 = var3;
                        var19.field851 = var5;
                        var19.field849 = var18.field2751;
                        Friend.method1075(var19);
                     }

                     boolean var11 = true;
                     if(var18.contentType > 0) {
                        var11 = class33.method340(var18);
                     }

                     if(var11 && class20.method133(class210.method3903(var18), var3 - 1)) {
                        if(var3 == 1) {
                           Client.secretPacketBuffer1.putOpcode(75);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 2) {
                           Client.secretPacketBuffer1.putOpcode(51);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 3) {
                           Client.secretPacketBuffer1.putOpcode(164);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 4) {
                           Client.secretPacketBuffer1.putOpcode(245);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 5) {
                           Client.secretPacketBuffer1.putOpcode(213);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 6) {
                           Client.secretPacketBuffer1.putOpcode(182);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 7) {
                           Client.secretPacketBuffer1.putOpcode(74);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 8) {
                           Client.secretPacketBuffer1.putOpcode(161);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 9) {
                           Client.secretPacketBuffer1.putOpcode(29);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }

                        if(var3 == 10) {
                           Client.secretPacketBuffer1.putOpcode(162);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var16);
                        }
                     }
                  }
               }
            }

            if(var2 == 7) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(40);
                  Client.secretPacketBuffer1.method3183(GameObject.field2212);
                  Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3227(var3);
                  Client.secretPacketBuffer1.method3227(IndexFile.field2303);
                  Client.secretPacketBuffer1.method3132(class109.field1645);
               }
            }

            if(var2 == 13) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(105);
                  Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3227(var3);
               }
            }

            if(var2 == 16) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(5);
               Client.secretPacketBuffer1.method3175(var3);
               Client.secretPacketBuffer1.method3227(class41.baseX + var0);
               Client.secretPacketBuffer1.putShort(WorldMapType3.baseY + var1);
               Client.secretPacketBuffer1.method3153(GameObject.field2212);
               Client.secretPacketBuffer1.putShort(IndexFile.field2303);
               Client.secretPacketBuffer1.method3166(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3175(class109.field1645);
            }

            if(var2 == 10) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(175);
                  Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3132(var3);
               }
            }

            if(var2 == 34) {
               Client.secretPacketBuffer1.putOpcode(11);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3153(var1);
               Client.secretPacketBuffer1.method3132(var0);
               Client.field932 = 0;
               class47.field614 = WorldMapType3.method199(var1);
               Client.field1035 = var0;
            }

            if(var2 == 18) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(110);
               Client.secretPacketBuffer1.method3175(var3);
               Client.secretPacketBuffer1.method3132(var1 + WorldMapType3.baseY);
               Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3132(var0 + class41.baseX);
            }

            if(var2 == 1) {
               Client.field1175 = var6;
               Client.field1038 = var7;
               Client.field1186 = 2;
               Client.field1000 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(115);
               Client.secretPacketBuffer1.method3132(var1 + WorldMapType3.baseY);
               Client.secretPacketBuffer1.method3227(class109.field1645);
               Client.secretPacketBuffer1.method3132(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
               Client.secretPacketBuffer1.method3175(IndexFile.field2303);
               Client.secretPacketBuffer1.method3183(GameObject.field2212);
               Client.secretPacketBuffer1.method3132(var0 + class41.baseX);
            }

            if(var2 == 9) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(77);
                  Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
                  Client.secretPacketBuffer1.method3132(var3);
               }
            }

            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(130);
               Client.secretPacketBuffer1.putInt(var1);
               var21 = WorldMapType3.method199(var1);
               if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
                  var16 = var21.dynamicValues[0][1];
                  if(var21.field2678[0] != class211.widgetSettings[var16]) {
                     class211.widgetSettings[var16] = var21.field2678[0];
                     class10.method47(var16);
                  }
               }
            }

            if(var2 == 43) {
               Client.secretPacketBuffer1.putOpcode(185);
               Client.secretPacketBuffer1.method3227(var3);
               Client.secretPacketBuffer1.method3153(var1);
               Client.secretPacketBuffer1.putShort(var0);
               Client.field932 = 0;
               class47.field614 = WorldMapType3.method199(var1);
               Client.field1035 = var0;
            }

            if(var2 == 8) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(208);
                  Client.secretPacketBuffer1.method3132(Client.field1086);
                  Client.secretPacketBuffer1.putInt(ChatMessages.field1528);
                  Client.secretPacketBuffer1.method3175(var3);
                  Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
               }
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class1.region.method2712();
               } else {
                  class1.region.method2746(FaceNormal.plane, var0, var1, true);
               }
            }

            if(var2 == 14) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(133);
                  Client.secretPacketBuffer1.method3132(var3);
                  Client.secretPacketBuffer1.method3132(class109.field1645);
                  Client.secretPacketBuffer1.putShort(IndexFile.field2303);
                  Client.secretPacketBuffer1.method3183(GameObject.field2212);
                  Client.secretPacketBuffer1.method3170(class50.field645[82]?1:0);
               }
            }

            if(var2 == 47) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field1175 = var6;
                  Client.field1038 = var7;
                  Client.field1186 = 2;
                  Client.field1000 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(66);
                  Client.secretPacketBuffer1.method3132(var3);
                  Client.secretPacketBuffer1.putByte(class50.field645[82]?1:0);
               }
            }

            if(var2 == 1005) {
               var21 = WorldMapType3.method199(var1);
               if(var21 != null && var21.itemQuantities[var0] >= 100000) {
                  class18.sendGameMessage(27, "", var21.itemQuantities[var0] + " x " + Buffer.getItemDefinition(var3).name);
               } else {
                  Client.secretPacketBuffer1.putOpcode(20);
                  Client.secretPacketBuffer1.method3175(var3);
               }

               Client.field932 = 0;
               class47.field614 = WorldMapType3.method199(var1);
               Client.field1035 = var0;
            }

            if(var2 == 33) {
               Client.secretPacketBuffer1.putOpcode(126);
               Client.secretPacketBuffer1.method3227(var0);
               Client.secretPacketBuffer1.method3153(var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.field932 = 0;
               class47.field614 = WorldMapType3.method199(var1);
               Client.field1035 = var0;
            }

            if(Client.field1083 != 0) {
               Client.field1083 = 0;
               class25.method169(WorldMapType3.method199(GameObject.field2212));
            }

            if(Client.field1085) {
               class9.method39();
            }

            if(class47.field614 != null && Client.field932 == 0) {
               class25.method169(class47.field614);
            }

         }
      }
   }

   class46(int var1) {
      this.field603 = var1;
   }
}

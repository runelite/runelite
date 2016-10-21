import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("t")
   static NodeCache field1030 = new NodeCache(64);
   @ObfuscatedName("h")
   public boolean field1031 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -326658517
   )
   public static int field1032;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 155824517
   )
   public int field1033 = -1;
   @ObfuscatedName("m")
   short[] field1035;
   @ObfuscatedName("k")
   short[] field1036;
   @ObfuscatedName("c")
   short[] field1037;
   @ObfuscatedName("w")
   short[] field1038;
   @ObfuscatedName("l")
   int[] field1039 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("b")
   int[] field1040;
   @ObfuscatedName("f")
   public static class170 field1041;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-677165516"
   )
   void method935(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1033 = var1.method2656();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2656();
            this.field1040 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1040[var4] = var1.method2535();
            }
         } else if(var2 == 3) {
            this.field1031 = true;
         } else if(var2 == 40) {
            var3 = var1.method2656();
            this.field1035 = new short[var3];
            this.field1036 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1035[var4] = (short)var1.method2535();
               this.field1036[var4] = (short)var1.method2535();
            }
         } else if(var2 == 41) {
            var3 = var1.method2656();
            this.field1037 = new short[var3];
            this.field1038 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1037[var4] = (short)var1.method2535();
               this.field1038[var4] = (short)var1.method2535();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1039[var2 - 60] = var1.method2535();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "53"
   )
   void method936(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method935(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class20.field573 = null;
            Tile.field1819 = null;
            class48.field1061 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field556 = 0;
            Client.field317 = 0;
            Client.field318 = 0;
         }

         if(var0 != 20 && var0 != 40 && class116.field2019 != null) {
            class116.field2019.method3010();
            class116.field2019 = null;
         }

         if(Client.gameState == 25) {
            Client.field561 = 0;
            Client.field337 = 0;
            Client.field338 = 1;
            Client.field339 = 0;
            Client.field340 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class4.method50(GameObject.canvas, XItemContainer.field226, Item.field690, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class4.method50(GameObject.canvas, XItemContainer.field226, Item.field690, false, 4);
            } else if(class33.field721) {
               class33.field748 = null;
               class33.field722 = null;
               class33.field723 = null;
               class33.field731 = null;
               class33.field725 = null;
               class33.field749 = null;
               class168.field2699 = null;
               class33.field727 = null;
               class33.field728 = null;
               class18.field259 = null;
               class47.field1045 = null;
               class33.field756 = null;
               class14.field213 = null;
               class8.field142 = null;
               class79.field1435 = null;
               class14.field211 = null;
               class4.field70 = null;
               class33.field733 = null;
               ChatLineBuffer.field685 = null;
               class188.field3046 = null;
               class33.field736 = null;
               class220.field3209 = null;
               class12.method146(2);
               XItemContainer.method174(true);
               class33.field721 = false;
            }
         } else {
            class4.method50(GameObject.canvas, XItemContainer.field226, Item.field690, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-71"
   )
   public boolean method940() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1039[var2] != -1 && !class181.field2947.method3353(this.field1039[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2106270926"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1040 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1040.length; ++var2) {
            if(!class181.field2947.method3353(this.field1040[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "108"
   )
   public ModelData method949() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1039[var3] != -1) {
            var1[var2++] = ModelData.method2236(class181.field2947, this.field1039[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field1035) {
         for(var4 = 0; var4 < this.field1035.length; ++var4) {
            var5.method2248(this.field1035[var4], this.field1036[var4]);
         }
      }

      if(null != this.field1037) {
         for(var4 = 0; var4 < this.field1037.length; ++var4) {
            var5.method2249(this.field1037[var4], this.field1038[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-856386697"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1040 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1040.length];

         for(int var4 = 0; var4 < this.field1040.length; ++var4) {
            var1[var4] = ModelData.method2236(class181.field2947, this.field1040[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field1035 != null) {
            for(var3 = 0; var3 < this.field1035.length; ++var3) {
               var2.method2248(this.field1035[var3], this.field1036[var3]);
            }
         }

         if(null != this.field1037) {
            for(var3 = 0; var3 < this.field1037.length; ++var3) {
               var2.method2249(this.field1037[var3], this.field1038[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1654617843"
   )
   static final void method957(String var0) {
      if(null != var0) {
         String var1 = class47.method967(var0, RSCanvas.field2188);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class47.method967(var4, RSCanvas.field2188);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[1 + var7];
                  }

                  Client.field472 = Client.field295;
                  Client.field397.method2768(173);
                  Client.field397.method2518(class75.method1624(var0));
                  Client.field397.method2524(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "805373063"
   )
   static int method959(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}

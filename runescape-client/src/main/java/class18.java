import java.awt.Component;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class18 {
   @ObfuscatedName("j")
   byte[] field251;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1134408763
   )
   int field252;
   @ObfuscatedName("f")
   DataInputStream field253;
   @ObfuscatedName("q")
   class149 field254;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1191784339
   )
   int field255;
   @ObfuscatedName("c")
   byte[] field256 = new byte[4];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 36859903
   )
   int field257;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -1340223049587002679L
   )
   long field258;
   @ObfuscatedName("s")
   static Buffer field261;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZS)Z",
      garbageValue = "-6272"
   )
   static boolean method178(File var0, boolean var1) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "359283144"
   )
   public static void method179(class170 var0) {
      class53.field1152 = var0;
   }

   class18(class139 var1, URL var2) {
      this.field254 = var1.method2920(var2);
      this.field252 = 0;
      this.field258 = class169.method3276() + 30000L;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "-1367787436"
   )
   static ModIcon method182() {
      ModIcon var0 = new ModIcon();
      var0.width = class79.field1436;
      var0.originalHeight = class79.field1437;
      var0.offsetX = class134.field2117[0];
      var0.offsetY = class79.field1438[0];
      var0.originalWidth = class79.field1439[0];
      var0.height = ChatLineBuffer.field693[0];
      var0.palette = class26.field634;
      var0.pixels = class110.field1936[0];
      NPC.method745();
      return var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "1623594675"
   )
   public static BufferProvider method183(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "1"
   )
   static void method184(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = ItemComposition.worldList[var6];
         ItemComposition.worldList[var6] = ItemComposition.worldList[var1];
         ItemComposition.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class220.method4001(ItemComposition.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = ItemComposition.worldList[var9];
               ItemComposition.worldList[var9] = ItemComposition.worldList[var7];
               ItemComposition.worldList[var7++] = var10;
            }
         }

         ItemComposition.worldList[var1] = ItemComposition.worldList[var7];
         ItemComposition.worldList[var7] = var8;
         method184(var0, var7 - 1, var2, var3, var4, var5);
         method184(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   static final void method185() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[1 + var1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[1 + var1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Ljava/lang/String;",
      garbageValue = "19"
   )
   static String method186(Widget var0) {
      int var2 = FrameMap.method2356(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(null != var0.field2877 && var0.field2877.trim().length() != 0?var0.field2877:null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1213084102"
   )
   byte[] method187() throws IOException {
      if(class169.method3276() > this.field258) {
         throw new IOException();
      } else {
         if(this.field252 == 0) {
            if(this.field254.field2268 == 2) {
               throw new IOException();
            }

            if(this.field254.field2268 == 1) {
               this.field253 = (DataInputStream)this.field254.field2262;
               this.field252 = 1;
            }
         }

         int var1;
         if(this.field252 == 1) {
            var1 = this.field253.available();
            if(var1 > 0) {
               if(var1 + this.field255 > 4) {
                  var1 = 4 - this.field255;
               }

               this.field255 += this.field253.read(this.field256, this.field255, var1);
               if(this.field255 == 4) {
                  int var2 = (new Buffer(this.field256)).method2576();
                  this.field251 = new byte[var2];
                  this.field252 = 2;
               }
            }
         }

         if(this.field252 == 2) {
            var1 = this.field253.available();
            if(var1 > 0) {
               if(var1 + this.field257 > this.field251.length) {
                  var1 = this.field251.length - this.field257;
               }

               this.field257 += this.field253.read(this.field251, this.field257, var1);
               if(this.field257 == this.field251.length) {
                  return this.field251;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1357248711"
   )
   static final void method188() {
      method185();
      if(class12.field182 == null) {
         if(null == Client.field453) {
            int var2;
            int var3;
            int var6;
            int var11;
            label268: {
               int var0 = class143.field2206;
               int var1;
               if(Client.isMenuOpen) {
                  if(var0 != 1 && (class124.field2066 || var0 != 4)) {
                     var1 = class143.field2200;
                     var2 = class143.field2204;
                     if(var1 < Client.menuX - 10 || var1 > class43.menuWidth + Client.menuX + 10 || var2 < class0.menuY - 10 || var2 > class26.menuHeight + class0.menuY + 10) {
                        Client.isMenuOpen = false;
                        ObjectComposition.method834(Client.menuX, class0.menuY, class43.menuWidth, class26.menuHeight);
                     }
                  }

                  if(var0 == 1 || !class124.field2066 && var0 == 4) {
                     var1 = Client.menuX;
                     var2 = class0.menuY;
                     var3 = class43.menuWidth;
                     int var4 = class143.field2207;
                     var11 = class143.field2196;
                     var6 = -1;

                     for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                        int var8 = var2 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
                        if(var4 > var1 && var4 < var3 + var1 && var11 > var8 - 13 && var11 < 3 + var8) {
                           var6 = var7;
                        }
                     }

                     if(var6 != -1) {
                        Frames.method2358(var6);
                     }

                     Client.isMenuOpen = false;
                     ObjectComposition.method834(Client.menuX, class0.menuY, class43.menuWidth, class26.menuHeight);
                  }
               } else {
                  if((var0 == 1 || !class124.field2066 && var0 == 4) && Client.menuOptionCount > 0) {
                     var1 = Client.menuTypes[Client.menuOptionCount - 1];
                     if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                        var2 = Client.menuActionParams0[Client.menuOptionCount - 1];
                        var3 = Client.menuActionParams1[Client.menuOptionCount - 1];
                        Widget var9 = class144.method3012(var3);
                        if(ItemLayer.method2272(FrameMap.method2356(var9))) {
                           break label268;
                        }

                        var6 = FrameMap.method2356(var9);
                        boolean var5 = (var6 >> 29 & 1) != 0;
                        if(var5) {
                           break label268;
                        }
                     }
                  }

                  if((var0 == 1 || !class124.field2066 && var0 == 4) && (Client.field419 == 1 && Client.menuOptionCount > 2 || class24.method603(Client.menuOptionCount - 1))) {
                     var0 = 2;
                  }

                  if((var0 == 1 || !class124.field2066 && var0 == 4) && Client.menuOptionCount > 0) {
                     Frames.method2358(Client.menuOptionCount - 1);
                  }

                  if(var0 == 2 && Client.menuOptionCount > 0) {
                     XItemContainer.method165(class143.field2207, class143.field2196);
                  }
               }

               return;
            }

            if(class12.field182 != null && !Client.field399 && Client.field419 != 1 && !class24.method603(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
               var11 = Client.field396;
               var6 = Client.field295;
               class32 var10 = class4.field67;
               Friend.menuAction(var10.field726, var10.field722, var10.field721, var10.field724, var10.field725, var10.field725, var11, var6);
               class4.field67 = null;
            }

            Client.field399 = false;
            Client.field428 = 0;
            if(class12.field182 != null) {
               class166.method3253(class12.field182);
            }

            class12.field182 = class144.method3012(var3);
            Client.field395 = var2;
            Client.field396 = class143.field2207;
            Client.field295 = class143.field2196;
            if(Client.menuOptionCount > 0) {
               class10.method121(Client.menuOptionCount - 1);
            }

            class166.method3253(class12.field182);
         }
      }
   }
}

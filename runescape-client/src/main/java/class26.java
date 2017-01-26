import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class26 {
   @ObfuscatedName("k")
   byte[] field573;
   @ObfuscatedName("g")
   class102 field574;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1782657987
   )
   int field575;
   @ObfuscatedName("q")
   byte[] field576 = new byte[4];
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -962354901
   )
   public static int field577;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1998694471
   )
   int field579;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -7167081414258901603L
   )
   long field580;
   @ObfuscatedName("r")
   static int[] field581;
   @ObfuscatedName("ec")
   static ModIcon[] field583;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1248655623
   )
   int field585;
   @ObfuscatedName("h")
   public static class60 field587;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -777816685
   )
   static int field588;
   @ObfuscatedName("x")
   DataInputStream field590;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1925534074"
   )
   static final void method575() {
      class33.method682(Client.field368);
      ++class176.field2653;
      if(Client.field448 && Client.field337) {
         int var0 = class115.field1805;
         int var1 = class115.field1814;
         var0 -= Client.field452;
         var1 -= Client.field551;
         if(var0 < Client.field456) {
            var0 = Client.field456;
         }

         if(var0 + Client.field368.width > Client.field456 + Client.field430.width) {
            var0 = Client.field430.width + Client.field456 - Client.field368.width;
         }

         if(var1 < Client.field457) {
            var1 = Client.field457;
         }

         if(Client.field368.height + var1 > Client.field457 + Client.field430.height) {
            var1 = Client.field430.height + Client.field457 - Client.field368.height;
         }

         int var2 = var0 - Client.field497;
         int var3 = var1 - Client.field460;
         int var4 = Client.field368.field2260;
         if(class176.field2653 > Client.field368.field2273 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field461 = true;
         }

         int var5 = Client.field430.scrollX + (var0 - Client.field456);
         int var6 = Client.field430.scrollY + (var1 - Client.field457);
         class18 var7;
         if(null != Client.field368.field2285 && Client.field461) {
            var7 = new class18();
            var7.field180 = Client.field368;
            var7.field183 = var5;
            var7.field184 = var6;
            var7.field188 = Client.field368.field2285;
            XItemContainer.method160(var7, 200000);
         }

         if(class115.field1804 == 0) {
            int var9;
            if(Client.field461) {
               if(null != Client.field368.field2286) {
                  var7 = new class18();
                  var7.field180 = Client.field368;
                  var7.field183 = var5;
                  var7.field184 = var6;
                  var7.field186 = Client.field454;
                  var7.field188 = Client.field368.field2286;
                  XItemContainer.method160(var7, 200000);
               }

               if(Client.field454 != null) {
                  Widget var8 = Client.field368;
                  int var10 = class36.method724(var8);
                  var9 = var10 >> 17 & 7;
                  int var11 = var9;
                  Widget var15;
                  if(var9 == 0) {
                     var15 = null;
                  } else {
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           var15 = var8;
                           break;
                        }

                        var8 = class37.method736(var8.parentId);
                        if(null == var8) {
                           var15 = null;
                           break;
                        }

                        ++var12;
                     }
                  }

                  if(var15 != null) {
                     Client.field394.method3037(166);
                     Client.field394.method2837(Client.field368.index);
                     Client.field394.method2855(Client.field454.id);
                     Client.field394.method2845(Client.field454.index);
                     Client.field394.method2855(Client.field368.id);
                     Client.field394.method2837(Client.field454.item);
                     Client.field394.method2837(Client.field368.item);
                  }
               }
            } else {
               label170: {
                  label141: {
                     if(Client.field384 != 1) {
                        int var14 = Client.menuOptionCount - 1;
                        boolean var13;
                        if(var14 < 0) {
                           var13 = false;
                        } else {
                           var9 = Client.menuTypes[var14];
                           if(var9 >= 2000) {
                              var9 -= 2000;
                           }

                           if(var9 == 1007) {
                              var13 = true;
                           } else {
                              var13 = false;
                           }
                        }

                        if(!var13) {
                           break label141;
                        }
                     }

                     if(Client.menuOptionCount > 2) {
                        Spotanim.method3463(Client.field497 + Client.field452, Client.field551 + Client.field460);
                        break label170;
                     }
                  }

                  if(Client.menuOptionCount > 0) {
                     Client.method423(Client.field452 + Client.field497, Client.field460 + Client.field551);
                  }
               }
            }

            Client.field368 = null;
         }

      } else {
         if(class176.field2653 > 1) {
            Client.field368 = null;
         }

      }
   }

   class26(class103 var1, URL var2) {
      this.field574 = var1.method1955(var2);
      this.field585 = 0;
      this.field580 = FrameMap.method1695() + 30000L;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "181136471"
   )
   byte[] method578() throws IOException {
      if(FrameMap.method1695() > this.field580) {
         throw new IOException();
      } else {
         if(this.field585 == 0) {
            if(this.field574.field1667 == 2) {
               throw new IOException();
            }

            if(this.field574.field1667 == 1) {
               this.field590 = (DataInputStream)this.field574.field1664;
               this.field585 = 1;
            }
         }

         int var1;
         if(this.field585 == 1) {
            var1 = this.field590.available();
            if(var1 > 0) {
               if(var1 + this.field575 > 4) {
                  var1 = 4 - this.field575;
               }

               this.field575 += this.field590.read(this.field576, this.field575, var1);
               if(this.field575 == 4) {
                  int var2 = (new Buffer(this.field576)).method2819();
                  this.field573 = new byte[var2];
                  this.field585 = 2;
               }
            }
         }

         if(this.field585 == 2) {
            var1 = this.field590.available();
            if(var1 > 0) {
               if(this.field579 + var1 > this.field573.length) {
                  var1 = this.field573.length - this.field579;
               }

               this.field579 += this.field590.read(this.field573, this.field579, var1);
               if(this.field573.length == this.field579) {
                  return this.field573;
               }
            }
         }

         return null;
      }
   }
}

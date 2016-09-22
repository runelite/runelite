import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class49 extends CacheableNode {
   @ObfuscatedName("d")
   static class170 field1090;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1408972329
   )
   public int field1091 = 255;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -759165365
   )
   public int field1092 = -1;
   @ObfuscatedName("r")
   public static NodeCache field1093 = new NodeCache(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 474956157
   )
   public int field1094;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 824064791
   )
   public int field1095 = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1549777009
   )
   public int field1096 = 255;
   @ObfuscatedName("a")
   static class170 field1098;
   @ObfuscatedName("v")
   public static NodeCache field1099 = new NodeCache(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 498659137
   )
   public int field1100 = 70;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1387174513
   )
   int field1101 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 83112781
   )
   int field1102 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 58575747
   )
   public int field1103 = 30;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1092901959
   )
   public int field1104 = 0;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2092398564"
   )
   void method1009(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1010(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1488461161"
   )
   void method1010(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2717();
      } else if(var2 == 2) {
         this.field1096 = var1.method2528();
      } else if(var2 == 3) {
         this.field1091 = var1.method2528();
      } else if(var2 == 4) {
         this.field1092 = 0;
      } else if(var2 == 5) {
         this.field1100 = var1.method2717();
      } else if(var2 == 6) {
         var1.method2528();
      } else if(var2 == 7) {
         this.field1101 = var1.method2543();
      } else if(var2 == 8) {
         this.field1102 = var1.method2543();
      } else if(var2 == 11) {
         this.field1092 = var1.method2717();
      } else if(var2 == 14) {
         this.field1103 = var1.method2528();
      } else if(var2 == 15) {
         this.field1104 = var1.method2528();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1109862662"
   )
   public SpritePixels method1012() {
      if(this.field1102 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1093.get((long)this.field1102);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class20.method565(field1090, this.field1102, 0);
            if(var1 != null) {
               field1093.put(var1, (long)this.field1102);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1928734593"
   )
   public static void method1023() {
      try {
         class152.field2304.method4199();

         for(int var0 = 0; var0 < class152.field2301; ++var0) {
            class232.field3276[var0].method4199();
         }

         class152.field2297.method4199();
         class152.field2299.method4199();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1190273929"
   )
   public SpritePixels method1024() {
      if(this.field1101 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1093.get((long)this.field1101);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class20.method565(field1090, this.field1101, 0);
            if(null != var1) {
               field1093.put(var1, (long)this.field1101);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-375035488"
   )
   static final void method1028() {
      class53.method1101(Client.field453);
      ++Client.field563;
      if(Client.field461 && Client.field458) {
         int var0 = class143.field2225;
         int var1 = class143.field2222;
         var0 -= Client.field511;
         var1 -= Client.field456;
         if(var0 < Client.field459) {
            var0 = Client.field459;
         }

         if(var0 + Client.field453.width > Client.field459 + Client.field443.width) {
            var0 = Client.field459 + Client.field443.width - Client.field453.width;
         }

         if(var1 < Client.field460) {
            var1 = Client.field460;
         }

         if(var1 + Client.field453.height > Client.field443.height + Client.field460) {
            var1 = Client.field460 + Client.field443.height - Client.field453.height;
         }

         int var2 = var0 - Client.field462;
         int var3 = var1 - Client.field463;
         int var4 = Client.field453.field2863;
         if(Client.field563 > Client.field453.field2893 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field464 = true;
         }

         int var5 = Client.field443.itemId + (var0 - Client.field459);
         int var6 = var1 - Client.field460 + Client.field443.scrollY;
         class0 var7;
         if(Client.field453.field2905 != null && Client.field464) {
            var7 = new class0();
            var7.field2 = Client.field453;
            var7.field3 = var5;
            var7.field4 = var6;
            var7.field7 = Client.field453.field2905;
            class1.method9(var7, 200000);
         }

         if(class143.field2220 == 0) {
            if(Client.field464) {
               if(null != Client.field453.field2906) {
                  var7 = new class0();
                  var7.field2 = Client.field453;
                  var7.field3 = var5;
                  var7.field4 = var6;
                  var7.field5 = Client.field457;
                  var7.field7 = Client.field453.field2906;
                  class1.method9(var7, 200000);
               }

               if(null != Client.field457) {
                  Widget var8 = Client.field453;
                  int var10 = GameEngine.method3133(var8);
                  int var9 = var10 >> 17 & 7;
                  int var11 = var9;
                  if(var9 == 0) {
                     var7 = null;
                  } else {
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           break;
                        }

                        var8 = class24.method600(var8.parentId);
                        if(var8 == null) {
                           var7 = null;
                           break;
                        }

                        ++var12;
                     }
                  }
               }
            } else if((Client.field341 == 1 || class0.method2(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               class50.method1044(Client.field462 + Client.field511, Client.field463 + Client.field456);
            } else if(Client.menuOptionCount > 0) {
               class92.method2112(Client.field511 + Client.field462, Client.field463 + Client.field456);
            }

            Client.field453 = null;
         }

      } else {
         if(Client.field563 > 1) {
            Client.field453 = null;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-799254088"
   )
   public static class45 method1029(int var0) {
      class45 var1 = (class45)class45.field1047.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1031.method3309(13, var0);
         var1 = new class45();
         var1.field1033 = var0;
         if(var2 != null) {
            var1.method936(new Buffer(var2));
         }

         class45.field1047.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "856862755"
   )
   static final boolean method1030(Widget var0) {
      if(var0.field2929 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2929.length; ++var1) {
            int var2 = class13.method166(var0, var1);
            int var3 = var0.field2930[var1];
            if(var0.field2929[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2929[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2929[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}

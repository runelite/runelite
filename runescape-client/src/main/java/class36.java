import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("NPC")
public final class class36 extends class39 {
   @ObfuscatedName("e")
   @Export("composition")
   class41 field825;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-49"
   )
   final void method751(int var1, byte var2) {
      int var3 = super.field885[0];
      int var4 = super.field906[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field890 != -1 && class13.method153(super.field890).field1035 == 1) {
         super.field890 = -1;
      }

      if(super.field852 < 9) {
         ++super.field852;
      }

      for(int var5 = super.field852; var5 > 0; --var5) {
         super.field885[var5] = super.field885[var5 - 1];
         super.field906[var5] = super.field906[var5 - 1];
         super.field907[var5] = super.field907[var5 - 1];
      }

      super.field885[0] = var3;
      super.field906[0] = var4;
      super.field907[0] = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1959558545"
   )
   final void method752(int var1, int var2, boolean var3) {
      if(super.field890 != -1 && class13.method153(super.field890).field1035 == 1) {
         super.field890 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field885[0];
         int var5 = var2 - super.field906[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field852 < 9) {
               ++super.field852;
            }

            for(int var6 = super.field852; var6 > 0; --var6) {
               super.field885[var6] = super.field885[var6 - 1];
               super.field906[var6] = super.field906[var6 - 1];
               super.field907[var6] = super.field907[var6 - 1];
            }

            super.field885[0] = var1;
            super.field906[0] = var2;
            super.field907[0] = 1;
            return;
         }
      }

      super.field852 = 0;
      super.field909 = 0;
      super.field908 = 0;
      super.field885[0] = var1;
      super.field906[0] = var2;
      super.field896 = super.field851 * 64 + 128 * super.field885[0];
      super.field879 = super.field851 * 64 + super.field906[0] * 128;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1207274637"
   )
   final boolean vmethod787() {
      return null != this.field825;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      if(this.field825 == null) {
         return null;
      } else {
         class44 var1 = super.field890 != -1 && super.field904 == 0?class13.method153(super.field890):null;
         class44 var2 = super.field900 != -1 && (super.field854 != super.field900 || var1 == null)?class13.method153(super.field900):null;
         class108 var3 = this.field825.method828(var1, super.field865, var2, super.field880);
         if(var3 == null) {
            return null;
         } else {
            var3.method2381();
            super.field855 = var3.field1529;
            if(super.field887 != -1 && super.field888 != -1) {
               class108 var4 = class151.method3217(super.field887).method964(super.field888);
               if(var4 != null) {
                  var4.method2390(0, -super.field891, 0);
                  class108[] var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(this.field825.field924 == 1) {
               var3.field1929 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass83;B)V",
      garbageValue = "-33"
   )
   static final void method762(class83 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class22.field606.length; ++var2) {
         class22.field606[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class22.field606[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class143.field2210[var5] = (class22.field606[128 + var5] + class22.field606[var5 - 128] + class22.field606[1 + var5] + class22.field606[var5 - 1]) / 4;
            }
         }

         int[] var8 = class22.field606;
         class22.field606 = class143.field2210;
         class143.field2210 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1489; ++var3) {
            for(var4 = 0; var4 < var0.field1486; ++var4) {
               if(var0.field1490[var2++] != 0) {
                  var5 = var0.field1488 + 16 + var4;
                  int var6 = var0.field1491 + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  class22.field606[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "755896475"
   )
   static final void method767(class125 var0, int var1) {
      int var2 = var0.field2061;
      class34.field806 = 0;
      int var3 = 0;
      var0.method2878();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class34.field804; ++var4) {
         var5 = class34.field807[var4];
         if((class34.field801[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class34.field801[var5] = (byte)(class34.field801[var5] | 2);
            } else {
               var6 = var0.method2859(1);
               if(var6 == 0) {
                  var3 = class52.method1132(var0);
                  class34.field801[var5] = (byte)(class34.field801[var5] | 2);
               } else {
                  class4.method42(var0, var5);
               }
            }
         }
      }

      var0.method2860();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2878();

         for(var4 = 0; var4 < class34.field804; ++var4) {
            var5 = class34.field807[var4];
            if((class34.field801[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class34.field801[var5] = (byte)(class34.field801[var5] | 2);
               } else {
                  var6 = var0.method2859(1);
                  if(var6 == 0) {
                     var3 = class52.method1132(var0);
                     class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                  } else {
                     class4.method42(var0, var5);
                  }
               }
            }
         }

         var0.method2860();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2878();

            for(var4 = 0; var4 < class34.field802; ++var4) {
               var5 = class34.field810[var4];
               if((class34.field801[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                  } else {
                     var6 = var0.method2859(1);
                     if(var6 == 0) {
                        var3 = class52.method1132(var0);
                        class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                     } else if(class21.method546(var0, var5)) {
                        class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                     }
                  }
               }
            }

            var0.method2860();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2878();

               for(var4 = 0; var4 < class34.field802; ++var4) {
                  var5 = class34.field810[var4];
                  if((class34.field801[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                     } else {
                        var6 = var0.method2859(1);
                        if(var6 == 0) {
                           var3 = class52.method1132(var0);
                           class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                        } else if(class21.method546(var0, var5)) {
                           class34.field801[var5] = (byte)(class34.field801[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2860();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field804 = 0;
                  class34.field802 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class34.field801[var4] = (byte)(class34.field801[var4] >> 1);
                     class2 var7 = client.field467[var4];
                     if(null != var7) {
                        class34.field807[++class34.field804 - 1] = var4;
                     } else {
                        class34.field810[++class34.field802 - 1] = var4;
                     }
                  }

                  class50.method1086(var0);
                  if(var1 != var0.field2061 - var2) {
                     throw new RuntimeException(var0.field2061 - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "16"
   )
   static long method768() {
      try {
         URL var0 = new URL(class49.method1060("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class122 var4 = new class122(new byte[1000]);

         do {
            int var5 = var3.read(var4.field2054, var4.field2061, 1000 - var4.field2061);
            if(var5 == -1) {
               var4.field2061 = 0;
               long var8 = var4.method2615();
               return var8;
            }

            var4.field2061 += var5;
         } while(var4.field2061 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}

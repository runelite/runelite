import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class166 {
   @ObfuscatedName("av")
   public static BufferProvider field2343;
   @ObfuscatedName("eg")
   static Font field2344;
   @ObfuscatedName("i")
   Inflater field2346;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IB)V",
      garbageValue = "37"
   )
   static void method3079(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1567()?1:0;
                     var12 = var8.method1567()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1567()?1:0;
                     var12 = var8.method1567()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method3079(var0, var1, var6, var3, var4);
         method3079(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "1621963599"
   )
   public void method3081(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2346 == null) {
            this.field2346 = new Inflater(true);
         }

         try {
            this.field2346.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2346.inflate(var2);
         } catch (Exception var4) {
            this.field2346.reset();
            throw new RuntimeException("");
         }

         this.field2346.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class166(int var1, int var2, int var3) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2049498298"
   )
   public static void method3082() {
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         ++class50.keyboardIdleTicks;
         class50.field635 = class50.field644;
         class50.field653 = 0;
         int var1;
         if(class50.field650 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class50.field645[var1] = false;
            }

            class50.field650 = class50.field648;
         } else {
            while(class50.field648 != class50.field650) {
               var1 = class50.field647[class50.field648];
               class50.field648 = class50.field648 + 1 & 127;
               if(var1 < 0) {
                  class50.field645[~var1] = false;
               } else {
                  if(!class50.field645[var1] && class50.field653 < class50.field652.length - 1) {
                     class50.field652[++class50.field653 - 1] = var1;
                  }

                  class50.field645[var1] = true;
               }
            }
         }

         if(class50.field653 > 0) {
            class50.keyboardIdleTicks = 0;
         }

         class50.field644 = class50.field649;
      }
   }

   public class166() {
      this(-1, 1000000, 1000000);
   }
}

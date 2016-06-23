import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class116 {
   @ObfuscatedName("f")
   Inflater field1984;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class116(int var1, int var2, int var3) {
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "-1483835994"
   )
   public void method2501(class119 var1, byte[] var2) {
      if(var1.field2000[var1.field1998] == 31 && var1.field2000[var1.field1998 + 1] == -117) {
         if(this.field1984 == null) {
            this.field1984 = new Inflater(true);
         }

         try {
            this.field1984.setInput(var1.field2000, 10 + var1.field1998, var1.field2000.length - (10 + var1.field1998 + 8));
            this.field1984.inflate(var2);
         } catch (Exception var4) {
            this.field1984.reset();
            throw new RuntimeException("");
         }

         this.field1984.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "48"
   )
   static void method2503(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field608.method3852(); var4 != null; var4 = (class23)class23.field608.method3857()) {
         if(var4.field610 != -1 || var4.field614 != null) {
            int var5 = 0;
            if(var1 > var4.field615) {
               var5 += var1 - var4.field615;
            } else if(var1 < var4.field605) {
               var5 += var4.field605 - var1;
            }

            if(var2 > var4.field616) {
               var5 += var2 - var4.field616;
            } else if(var2 < var4.field606) {
               var5 += var4.field606 - var2;
            }

            if(var5 - 64 <= var4.field603 && client.field349 != 0 && var0 == var4.field604) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field603 - var5) * client.field349 / var4.field603;
               if(var4.field611 == null) {
                  if(var4.field610 >= 0) {
                     class58 var7 = class58.method1314(class136.field2101, var4.field610, 0);
                     if(var7 != null) {
                        class62 var8 = var7.method1308().method1340(class12.field194);
                        class64 var9 = class64.method1361(var8, 100, var6);
                        var9.method1383(-1);
                        class121.field2014.method1229(var9);
                        var4.field611 = var9;
                     }
                  }
               } else {
                  var4.field611.method1365(var6);
               }

               if(null == var4.field607) {
                  if(var4.field614 != null && (var4.field609 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field614.length);
                     class58 var12 = class58.method1314(class136.field2101, var4.field614[var11], 0);
                     if(null != var12) {
                        class62 var13 = var12.method1308().method1340(class12.field194);
                        class64 var10 = class64.method1361(var13, 100, var6);
                        var10.method1383(0);
                        class121.field2014.method1229(var10);
                        var4.field607 = var10;
                        var4.field609 = var4.field612 + (int)(Math.random() * (double)(var4.field613 - var4.field612));
                     }
                  }
               } else {
                  var4.field607.method1365(var6);
                  if(!var4.field607.method3942()) {
                     var4.field607 = null;
                  }
               }
            } else {
               if(null != var4.field611) {
                  class121.field2014.method1200(var4.field611);
                  var4.field611 = null;
               }

               if(null != var4.field607) {
                  class121.field2014.method1200(var4.field607);
                  var4.field607 = null;
               }
            }
         }
      }

   }
}

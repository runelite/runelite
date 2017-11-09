import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class189 {
   @ObfuscatedName("m")
   static final String[][] field2536;
   @ObfuscatedName("p")
   static final String[] field2534;
   @ObfuscatedName("i")
   static Calendar field2535;

   static {
      field2536 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2534 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2535 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Lhk;",
      garbageValue = "-1676975478"
   )
   public static Widget method3613(int var0, int var1) {
      Widget var2 = PendingSpawn.method1612(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILfe;Liy;I)V",
      garbageValue = "-929108548"
   )
   static void method3616(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class243.field3297;
      synchronized(class243.field3297) {
         for(FileSystem var5 = (FileSystem)class243.field3297.getFront(); var5 != null; var5 = (FileSystem)class243.field3297.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.field3267 == 0) {
               var3 = var5.field3265;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4389(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3126(var0);
         var2.method4389(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "861110566"
   )
   static int method3617(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class82.intStack[--class56.intStackSize];
         class82.intStack[++class56.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class82.intStack[--class56.intStackSize];
         class82.intStack[++class56.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class56.intStackSize -= 5;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         int var5 = class82.intStack[class56.intStackSize + 2];
         int var6 = class82.intStack[class56.intStackSize + 3];
         int var7 = class82.intStack[class56.intStackSize + 4];
         class82.intStack[++class56.intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class56.intStackSize - 1] = 0;
         } else {
            class82.intStack[++class56.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class56.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class82.intStack[++class56.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class82.intStack[++class56.intStackSize - 1] = var3;
               break;
            case 2:
               class82.intStack[++class56.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class82.intStack[++class56.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class82.intStack[++class56.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class82.intStack[++class56.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class56.intStackSize -= 2;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         class82.intStack[++class56.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class56.intStackSize -= 3;
         long var9 = (long)class82.intStack[class56.intStackSize];
         long var11 = (long)class82.intStack[class56.intStackSize + 1];
         long var13 = (long)class82.intStack[class56.intStackSize + 2];
         class82.intStack[++class56.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   static final void method3614() {
      int var0 = CacheFile.menuX;
      int var1 = class45.menuY;
      int var2 = class256.menuWidth;
      int var3 = class18.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method5151(var0, var1, var2, var3, var4);
      Rasterizer2D.method5151(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class20.field320.method4931("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.field704;
      int var6 = MouseInput.field708;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class20.field320.method4931(class21.method175(var7), var0 + 3, var8, var9, 0);
      }

      class182.method3521(CacheFile.menuX, class45.menuY, class256.menuWidth, class18.menuHeight);
   }
}

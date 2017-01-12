import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class32 {
   @ObfuscatedName("a")
   static String[] field717;
   @ObfuscatedName("i")
   static int[] field719;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1240360913
   )
   static int field722 = 0;
   @ObfuscatedName("d")
   static int[] field723 = new int[1000];
   @ObfuscatedName("l")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1622348463
   )
   static int field725 = 0;
   @ObfuscatedName("z")
   static class11[] field726 = new class11[50];
   @ObfuscatedName("f")
   static int[] field727 = new int[5];
   @ObfuscatedName("e")
   static final String[] field728 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("q")
   static Calendar field730 = Calendar.getInstance();
   @ObfuscatedName("c")
   static int[][] field731 = new int[5][5000];

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field434 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field434) {
         var1 = Client.field409.method2922();
         var2 = Client.field409.method2922();
         var3 = Client.field409.readUnsignedShort();
         Tile.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Tile.xteaKeys[var4][var5] = Client.field409.method2780();
            }
         }

         class183.mapRegions = new int[var3];
         Actor.field659 = new int[var3];
         class25.field582 = new int[var3];
         class104.field1680 = new byte[var3][];
         class7.field59 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class183.mapRegions[var3] = var7;
                  Actor.field659[var3] = Client.field563.method3277("m" + var5 + "_" + var6);
                  class25.field582[var3] = Client.field563.method3277("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class20.method190(var1, var2);
      } else {
         var1 = Client.field409.method2779();
         var2 = Client.field409.method2922();
         var3 = Client.field409.readUnsignedShort();
         Client.field409.method3031();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field409.method3032(1);
                  if(var7 == 1) {
                     Client.field345[var4][var5][var6] = Client.field409.method3032(26);
                  } else {
                     Client.field345[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field409.method3040();
         Tile.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Tile.xteaKeys[var4][var5] = Client.field409.method2780();
            }
         }

         class183.mapRegions = new int[var3];
         Actor.field659 = new int[var3];
         class25.field582 = new int[var3];
         class104.field1680 = new byte[var3][];
         class7.field59 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field345[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class183.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class183.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        Actor.field659[var3] = Client.field563.method3277("m" + var11 + "_" + var12);
                        class25.field582[var3] = Client.field563.method3277("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class20.method190(var1, var2);
      }

   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "1790779825"
   )
   static String method690(Widget var0) {
      int var2 = GameObject.method1872(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(null != var0.field2264 && var0.field2264.trim().length() != 0?var0.field2264:null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "70"
   )
   static String method691(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-312598920"
   )
   static void method692(int var0, int var1, int var2, int var3) {
      Widget var4 = class157.method3011(var0, var1);
      if(var4 != null && var4.field2276 != null) {
         class18 var5 = new class18();
         var5.field195 = var4;
         var5.field203 = var4.field2276;
         class49.method871(var5, 200000);
      }

      Client.field437 = var3;
      Client.field435 = true;
      class2.field16 = var0;
      Client.field436 = var1;
      class214.field3158 = var2;
      class6.method87(var4);
   }
}

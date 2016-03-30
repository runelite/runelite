import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class32 {
   @ObfuscatedName("ef")
   static class78 field746;
   @ObfuscatedName("t")
   static byte[] field747 = new byte[2048];
   @ObfuscatedName("a")
   static int[] field748 = new int[2048];
   @ObfuscatedName("e")
   static class119[] field749 = new class119[2048];
   @ObfuscatedName("y")
   static String[] field750 = new String[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1102063663
   )
   static int field751 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -41436293
   )
   static int field753 = 0;
   @ObfuscatedName("p")
   static byte[] field754 = new byte[2048];
   @ObfuscatedName("j")
   static int[] field755 = new int[2048];
   @ObfuscatedName("c")
   static int[] field757 = new int[2048];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -212852815
   )
   static int field758 = 0;
   @ObfuscatedName("l")
   static int[] field759 = new int[2048];
   @ObfuscatedName("d")
   static class119 field760 = new class119(new byte[5000]);
   @ObfuscatedName("s")
   static int[] field761 = new int[2048];
   @ObfuscatedName("z")
   static int[] field764 = new int[2048];

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1953294225"
   )
   static void method727() {
      for(int var0 = 0; var0 < client.field435; ++var0) {
         if(class126.method2805(client.field448[var0])) {
            if(var0 < client.field435 - 1) {
               for(int var1 = var0; var1 < client.field435 - 1; ++var1) {
                  client.field440[var1] = client.field440[1 + var1];
                  client.field441[var1] = client.field441[1 + var1];
                  client.field448[var1] = client.field448[1 + var1];
                  client.field439[var1] = client.field439[var1 + 1];
                  client.field436[var1] = client.field436[var1 + 1];
                  client.field437[var1] = client.field437[var1 + 1];
               }
            }

            --client.field435;
         }
      }

   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "1370790537"
   )
   static final void method728(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var3.field2786 == var1 && (!var3.field2766 || !class102.method2282(var3))) {
            if(0 == var3.field2814) {
               if(!var3.field2766 && class102.method2282(var3) && var3 != class99.field1693) {
                  continue;
               }

               method728(var0, var3.field2838);
               if(var3.field2891 != null) {
                  method728(var3.field2891, var3.field2838);
               }

               class3 var4 = (class3)client.field455.method3806((long)var3.field2838);
               if(null != var4) {
                  class24.method609(var4.field74);
               }
            }

            if(6 == var3.field2814) {
               int var5;
               if(-1 != var3.field2851 || -1 != var3.field2815) {
                  boolean var7 = class50.method1058(var3);
                  if(var7) {
                     var5 = var3.field2815;
                  } else {
                     var5 = var3.field2851;
                  }

                  if(var5 != -1) {
                     class42 var6 = class96.method2187(var5);

                     for(var3.field2898 += client.field370; var3.field2898 > var6.field997[var3.field2889]; class134.method2877(var3)) {
                        var3.field2898 -= var6.field997[var3.field2889];
                        ++var3.field2889;
                        if(var3.field2889 >= var6.field995.length) {
                           var3.field2889 -= var6.field999;
                           if(var3.field2889 < 0 || var3.field2889 >= var6.field995.length) {
                              var3.field2889 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2823 != 0 && !var3.field2766) {
                  int var8 = var3.field2823 >> 16;
                  var5 = var3.field2823 << 16 >> 16;
                  var8 *= client.field370;
                  var5 *= client.field370;
                  var3.field2763 = var8 + var3.field2763 & 2047;
                  var3.field2819 = var5 + var3.field2819 & 2047;
                  class134.method2877(var3);
               }
            }
         }
      }

   }
}

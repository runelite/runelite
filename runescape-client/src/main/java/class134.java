import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class134 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -65074499
   )
   static int field1993;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 84102831
   )
   public static int field1994;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -697810279
   )
   public static int field1995;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2110802091
   )
   static int field1997;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1625725197
   )
   static int field1998;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -222148195
   )
   static int field1999;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2012329625
   )
   public static int field2000;
   @ObfuscatedName("g")
   public static int[] field2002;
   @ObfuscatedName("pa")
   static class109 field2003;
   @ObfuscatedName("t")
   public static boolean field2004;
   @ObfuscatedName("p")
   public static boolean field2006;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LRSSocket;ZB)V",
      garbageValue = "-99"
   )
   public static void method2489(RSSocket var0, boolean var1) {
      if(class238.field3258 != null) {
         try {
            class238.field3258.close();
         } catch (Exception var7) {
            ;
         }

         class238.field3258 = null;
      }

      class238.field3258 = var0;
      class169.method3002(var1);
      class238.field3270.offset = 0;
      class51.field668 = null;
      class77.field1207 = null;
      class238.field3264 = 0;

      while(true) {
         class234 var2 = (class234)class238.field3262.method3435();
         if(var2 == null) {
            while(true) {
               var2 = (class234)class238.field3263.method3435();
               if(var2 == null) {
                  if(class238.field3274 != 0) {
                     try {
                        Buffer var3 = new Buffer(4);
                        var3.putByte(4);
                        var3.putByte(class238.field3274);
                        var3.putShort(0);
                        class238.field3258.queueForWrite(var3.payload, 0, 4);
                     } catch (IOException var6) {
                        try {
                           class238.field3258.close();
                        } catch (Exception var5) {
                           ;
                        }

                        ++class238.field3276;
                        class238.field3258 = null;
                     }
                  }

                  class238.field3266 = 0;
                  class238.field3278 = class166.method2970();
                  return;
               }

               class238.field3259.method3376(var2);
               class238.field3265.method3426(var2, var2.hash);
               ++class238.field3261;
               --class238.field3268;
            }
         }

         class238.field3260.method3426(var2, var2.hash);
         ++class238.field3267;
         --class238.field3269;
      }
   }

   static {
      field2006 = false;
      field1994 = 0;
      field1995 = 0;
      field2004 = false;
      field2000 = 0;
      field2002 = new int[1000];
   }
}

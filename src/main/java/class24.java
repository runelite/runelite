import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("k")
@Implements("XClanMember")
public class class24 extends class207 {
   @ObfuscatedName("bs")
   static class167 field623;
   @ObfuscatedName("a")
   @Export("username")
   String field624;
   @ObfuscatedName("s")
   @Export("rank")
   byte field626;
   @ObfuscatedName("r")
   String field627;
   @ObfuscatedName("pu")
   static GarbageCollectorMXBean field628;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -459488297
   )
   @Export("world")
   int field629;

   @ObfuscatedName("r")
   public static class43 method595(int var0) {
      class43 var1 = (class43)class43.field1008.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field1011.method3263(13, var0);
         var1 = new class43();
         var1.field1010 = var0;
         if(var2 != null) {
            var1.method907(new class118(var2));
         }

         class43.field1008.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   static void method596() {
      class5.field72 = 99;
      class5.field74 = new byte[4][104][104];
      class5.field75 = new byte[4][104][104];
      class5.field76 = new byte[4][104][104];
      class5.field73 = new byte[4][104][104];
      class5.field80 = new int[4][105][105];
      class5.field78 = new byte[4][105][105];
      class5.field71 = new int[105][105];
      class72.field1351 = new int[104];
      class169.field2697 = new int[104];
      class209.field3119 = new int[104];
      class16.field240 = new int[104];
      class219.field3166 = new int[104];
   }

   @ObfuscatedName("m")
   public static boolean method597(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}

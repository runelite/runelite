import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class35 {
   @ObfuscatedName("l")
   static class156 field772;
   @ObfuscatedName("r")
   static final class35 field773 = new class35();
   @ObfuscatedName("j")
   static final class35 field774 = new class35();
   @ObfuscatedName("p")
   static class157 field775;
   @ObfuscatedName("i")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -1535719511
   )
   static int field777;
   @ObfuscatedName("z")
   static final class35 field778 = new class35();
   @ObfuscatedName("bx")
   static class171 field779;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = -9008073421087534211L
   )
   static long field780;
   @ObfuscatedName("x")
   static final class35 field782 = new class35();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2107460827
   )
   public static int field785;
   @ObfuscatedName("t")
   public static class231[] field790;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "1291634223"
   )
   public static class56 method714(int var0) {
      class56 var1 = (class56)class56.field1210.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1214.method3290(16, var0);
         var1 = new class56();
         if(null != var2) {
            var1.method1165(new Buffer(var2));
         }

         class56.field1210.put(var1, (long)var0);
         return var1;
      }
   }
}

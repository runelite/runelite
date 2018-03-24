import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class229 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static IndexDataBase field2678;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static IndexDataBase field2675;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public static class230 field2673;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1957132757
   )
   public static int field2674;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field2672;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 693748113
   )
   public static int field2676;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -331877721
   )
   public static int field2677;

   static {
      field2674 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lcq;",
      garbageValue = "-379017910"
   )
   static AttackOption[] method4159() {
      return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1021619853"
   )
   static void method4165() {
      class93.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class93.field1405[var0] = null;
         class93.field1393[var0] = 1;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "6"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "998148305"
   )
   static final void method4163(String var0) {
      MapIconReference.method757("Please remove " + var0 + " from your friend list first");
   }
}

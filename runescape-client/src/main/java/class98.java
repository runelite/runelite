import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class98 {
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("c")
   static final class186 field1532;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1206913267
   )
   static int field1533;
   @ObfuscatedName("e")
   static final class201 field1534;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 698376513
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "-1782263486"
   )
   public static CombatInfo2 method1830(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3362.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3374.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4397(new Buffer(var2));
         }

         CombatInfo2.field3362.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      chatLineMap = new HashMap();
      field1532 = new class186(1024);
      field1534 = new class201();
      field1533 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-889925934"
   )
   public static void method1839() {
      class251.field3384.reset();
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class223 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-675489132"
   )
   public static boolean method4072() {
      ClassInfo var0 = (ClassInfo)class280.field3755.method3547();
      return var0 != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "-2010276353"
   )
   public static boolean method4073(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Spotanim.decodeSprite(var3);
         return true;
      }
   }
}

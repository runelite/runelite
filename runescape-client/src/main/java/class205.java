import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public final class class205 {
   @ObfuscatedName("s")
   public static Font field3070;
   @ObfuscatedName("u")
   static int[] field3071;
   @ObfuscatedName("k")
   static final char[] field3075 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   class205() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "92"
   )
   public static final boolean method3821() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1718 == class105.field1717) {
            return false;
         } else {
            class44.field893 = class105.field1714[class105.field1718];
            XClanMember.field273 = class105.field1701[class105.field1718];
            class105.field1718 = class105.field1718 + 1 & 127;
            return true;
         }
      }
   }
}

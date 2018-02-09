import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class70 extends class168 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "1240062680"
   )
   protected boolean vmethod3396(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2229 && var3 == super.field2228;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lfi;",
      garbageValue = "481498352"
   )
   static LoginPacket[] method1113() {
      return new LoginPacket[]{LoginPacket.field2418, LoginPacket.field2419, LoginPacket.field2422, LoginPacket.field2417};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2056654404"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "978371239"
   )
   public static boolean method1116(int var0) {
      return var0 >= class232.field2935.field2938 && var0 <= class232.field2936.field2938;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4783"
   )
   static final void method1118() {
      BoundingBox3D.method49("Your friend list is full. Max of 200 for free users, and 400 for members");
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class203 {
   @ObfuscatedName("z")
   public static class112 field2509;
   @ObfuscatedName("c")
   public static IndexDataBase field2510;
   @ObfuscatedName("v")
   public static class204 field2511;
   @ObfuscatedName("i")
   public static IndexDataBase field2512;
   @ObfuscatedName("y")
   public static IndexDataBase field2513;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 816015785
   )
   public static int field2514;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -896087141
   )
   public static int field2515;

   static {
      field2514 = 0;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "546328156"
   )
   static final void method3665(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(178);
      Client.secretPacketBuffer1.putByte(class5.method11(var0) + 1);
      Client.secretPacketBuffer1.method3150(var0);
      Client.secretPacketBuffer1.method3170(var1);
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-1441460856"
   )
   static final void method3666(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field1090 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }
}

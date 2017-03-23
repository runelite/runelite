import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class18 extends Node {
   @ObfuscatedName("i")
   boolean field197;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2053021253
   )
   int field198;
   @ObfuscatedName("f")
   Object[] field199;
   @ObfuscatedName("w")
   String field200;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1630244669
   )
   int field201;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2021597433
   )
   int field202;
   @ObfuscatedName("l")
   Widget field203;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -497123871
   )
   int field204;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1788866729
   )
   int field205;
   @ObfuscatedName("u")
   Widget field207;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1023619441
   )
   int field208;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "116"
   )
   static int method173(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class30.field713 -= 2;
         var3 = class32.field743[class30.field713];
         int var4 = class32.field743[class30.field713 + 1];
         if(!Client.field446) {
            Client.field398 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class32.field743[++class30.field713 - 1] = Client.field398;
         return 1;
      } else if(var0 == 5506) {
         class32.field743[++class30.field713 - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class32.field743[--class30.field713];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field572 = var3;
         return 1;
      } else if(var0 == 5531) {
         class32.field743[++class30.field713 - 1] = Client.field572;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)LMessageNode;",
      garbageValue = "108"
   )
   static MessageNode method174(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method934(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-27"
   )
   public static int method175() {
      return class105.keyboardIdleTicks;
   }
}

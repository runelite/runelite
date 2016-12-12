import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1182588243
   )
   @Export("world")
   int world;
   @ObfuscatedName("e")
   String field271;
   @ObfuscatedName("em")
   static SpritePixels[] field273;
   @ObfuscatedName("cr")
   public static char field275;
   @ObfuscatedName("i")
   @Export("username")
   String username;
   @ObfuscatedName("k")
   @Export("rank")
   byte rank;

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-575434688"
   )
   static final void method237(boolean var0) {
      class115.method2194();
      ++Client.field333;
      if(Client.field333 >= 50 || var0) {
         Client.field333 = 0;
         if(!Client.field411 && null != class156.field2118) {
            Client.field294.method2976(212);

            try {
               class156.field2118.method2032(Client.field294.payload, 0, Client.field294.offset);
               Client.field294.offset = 0;
            } catch (IOException var2) {
               Client.field411 = true;
            }
         }

      }
   }
}

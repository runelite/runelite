import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static IndexFile field929;
   @ObfuscatedName("h")
   String field927;
   @ObfuscatedName("j")
   @Export("username")
   String username;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1792303631
   )
   @Export("world")
   int world;
   @ObfuscatedName("p")
   @Export("rank")
   byte rank;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "288438858"
   )
   public static void method1208() {
      class255.field3402.reset();
      class255.field3403.reset();
      class255.field3404.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-10386"
   )
   public static final boolean method1207() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field652 == KeyFocusListener.field659) {
            return false;
         } else {
            class48.field625 = KeyFocusListener.field633[KeyFocusListener.field659];
            class221.field2807 = KeyFocusListener.field631[KeyFocusListener.field659];
            KeyFocusListener.field659 = KeyFocusListener.field659 + 1 & 127;
            return true;
         }
      }
   }
}

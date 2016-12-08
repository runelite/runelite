import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("m")
   String field278;
   @ObfuscatedName("g")
   @Export("rank")
   byte rank;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1860930055
   )
   @Export("world")
   int world;
   @ObfuscatedName("o")
   @Export("username")
   String username;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 164515407
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-1881494865"
   )
   public static final class57 method236(class103 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1038 = new int[256 * (class57.field1044?2:1)];
            var4.field1047 = var3;
            var4.vmethod1090(var1);
            var4.field1046 = 1024 + (var3 & -1024);
            if(var4.field1046 > 16384) {
               var4.field1046 = 16384;
            }

            var4.vmethod1091(var4.field1046);
            if(class0.field0 > 0 && class57.field1048 == null) {
               class57.field1048 = new class63();
               class57.field1048.field1088 = var0;
               var0.method1939(class57.field1048, class0.field0);
            }

            if(null != class57.field1048) {
               if(null != class57.field1048.field1092[var2]) {
                  throw new IllegalArgumentException();
               }

               class57.field1048.field1092[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   public static final void method237(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            World.method607(var0 - 1L);
            World.method607(1L);
         } else {
            World.method607(var0);
         }

      }
   }
}

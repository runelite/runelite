import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("p")
   @Export("username")
   String username;
   @ObfuscatedName("q")
   @Export("rank")
   byte rank;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -531052999
   )
   @Export("world")
   int world;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1788476517
   )
   static int field272;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -638939325
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("g")
   String field277;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-101"
   )
   static void method250(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class5.worldList[var6];
         class5.worldList[var6] = class5.worldList[var1];
         class5.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class112.method2099(class5.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = class5.worldList[var9];
               class5.worldList[var9] = class5.worldList[var7];
               class5.worldList[var7++] = var10;
            }
         }

         class5.worldList[var1] = class5.worldList[var7];
         class5.worldList[var7] = var8;
         method250(var0, var7 - 1, var2, var3, var4, var5);
         method250(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "-3"
   )
   static void method251(File var0) {
      class107.field1726 = var0;
      if(!class107.field1726.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1731 = true;
      }
   }
}

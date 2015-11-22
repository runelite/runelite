package net.runelite.rs.client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hl")
public class class209 extends class207 {
   @ObfuscatedName("i")
   Method[] field3107;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 980337493
   )
   int field3108;
   @ObfuscatedName("u")
   int[] field3109;
   @ObfuscatedName("h")
   Field[] field3110;
   @ObfuscatedName("a")
   int[] field3111;
   @ObfuscatedName("f")
   int[] field3112;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 677341763
   )
   int field3113;
   @ObfuscatedName("m")
   byte[][][] field3114;

   @ObfuscatedName("x")
   static void method3978(class42 var0, int var1, int var2, int var3) {
      if(client.field516 < 50 && client.field515 != 0) {
         if(null != var0.field971 && var1 < var0.field971.length) {
            int var4 = var0.field971[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field462[client.field516] = var5;
               client.field518[client.field516] = var6;
               client.field519[client.field516] = 0;
               client.field521[client.field516] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field467[client.field516] = (var9 << 8) + (var8 << 16) + var7;
               ++client.field516;
            }
         }
      }
   }
}

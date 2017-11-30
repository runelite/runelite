import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("fm")
   static byte[][] field842;
   @ObfuscatedName("a")
   @Export("username")
   String username;
   @ObfuscatedName("w")
   String field840;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 65229773
   )
   @Export("world")
   int world;
   @ObfuscatedName("k")
   @Export("rank")
   byte rank;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1118490454"
   )
   static boolean method1118(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(Lhz;B)Z",
      garbageValue = "73"
   )
   static final boolean method1117(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class278.method4994(var0, var1);
            int var3 = var0.field2837[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}

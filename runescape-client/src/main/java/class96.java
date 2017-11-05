import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class96 {
   @ObfuscatedName("w")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static final IterableHashTable field1516;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static final class201 field1517;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 792831739
   )
   static int field1515;

   static {
      chatLineMap = new HashMap();
      field1516 = new IterableHashTable(1024);
      field1517 = new class201();
      field1515 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "1561622273"
   )
   public static String method1880(byte[] var0) {
      return DecorativeObject.method2923(var0, 0, var0.length);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(BB)C",
      garbageValue = "25"
   )
   public static char method1879(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3666[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }
}

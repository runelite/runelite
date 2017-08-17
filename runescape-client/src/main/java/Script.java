import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field1548;
   @ObfuscatedName("h")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("f")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2097382571
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1333882737
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("p")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 889194183
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 9122779
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lgd;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1548 = new NodeCache(128);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)[Lgd;",
      garbageValue = "126"
   )
   IterableHashTable[] method1864(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2067900426"
   )
   static long method1871() {
      try {
         URL var0 = new URL(CombatInfo1.method1553("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class251 extends CacheableNode {
   @ObfuscatedName("r")
   boolean field3395;
   @ObfuscatedName("a")
   char field3397;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -3128223
   )
   public int field3398;
   @ObfuscatedName("i")
   public static IndexDataBase field3399;
   @ObfuscatedName("w")
   static NodeCache field3400;
   @ObfuscatedName("s")
   public String field3401;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "554944914"
   )
   void method4437() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1849337015"
   )
   void method4438(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4441(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "90532835"
   )
   public boolean method4440() {
      return this.field3397 == 115;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2026051054"
   )
   void method4441(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var3 = var1.readByte();
         int var4 = var3 & 255;
         if(var4 == 0) {
            throw new IllegalArgumentException("");
         }

         char var5;
         if(var4 >= 128 && var4 < 160) {
            var5 = class266.field3668[var4 - 128];
            if(var5 == 0) {
               var5 = 63;
            }

            var4 = var5;
         }

         var5 = (char)var4;
         this.field3397 = var5;
      } else if(var2 == 2) {
         this.field3398 = var1.readInt();
      } else if(var2 == 4) {
         this.field3395 = false;
      } else if(var2 == 5) {
         this.field3401 = var1.readString();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "173920005"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3456 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "0"
   )
   static final String[] method4456(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   class251() {
      this.field3395 = true;
   }

   static {
      field3400 = new NodeCache(64);
   }
}

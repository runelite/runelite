import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class10 extends class16 {
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   static TextureProvider field72;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;I)V",
      garbageValue = "-372490911"
   )
   void method104(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class25.field227.field228) {
         throw new IllegalStateException("");
      } else {
         super.field133 = var2.readUnsignedByte();
         super.field134 = var2.readUnsignedByte();
         super.field131 = var2.readUnsignedShort();
         super.field135 = var2.readUnsignedShort();
         super.field141 = var2.readUnsignedShort();
         super.field132 = var2.readUnsignedShort();
         super.field134 = Math.min(super.field134, 4);
         super.field129 = new short[1][64][64];
         super.field130 = new short[super.field134][64][64];
         super.field137 = new byte[super.field134][64][64];
         super.field138 = new byte[super.field134][64][64];
         super.decorations = new WorldMapDecoration[super.field134][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class24.field222.field219) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field141 && var5 == super.field132) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method165(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field141 | super.field132 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class10)) {
         return false;
      } else {
         class10 var2 = (class10)var1;
         return var2.field141 == super.field141 && super.field132 == var2.field132;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-114"
   )
   static String method101() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class83.messages.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}

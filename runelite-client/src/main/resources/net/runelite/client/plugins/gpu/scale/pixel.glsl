// Anti-aliased UI scaling that respects pixel sharpness
// Approach taken from https://colececil.dev/blog/2017/scaling-pixel-art-without-destroying-it/

vec4 texturePixel(sampler2D sampler, vec2 texUV) {
  vec2 textureCoords = texUV * vec2(sourceDimensions);
  vec2 locationWithinTexel = fract(textureCoords);
  vec2 pixelsPerTexel = vec2(targetDimensions) / vec2(sourceDimensions);
  vec2 interpolationAmount = clamp(locationWithinTexel * pixelsPerTexel, 0, 0.5) + clamp((locationWithinTexel - vec2(1.0,1.0)) * pixelsPerTexel + vec2(0.5,0.5), 0, 0.5);
  vec2 finalTextureCoords = (floor(textureCoords) + interpolationAmount) / vec2(sourceDimensions);
  return texture(sampler, finalTextureCoords);
}